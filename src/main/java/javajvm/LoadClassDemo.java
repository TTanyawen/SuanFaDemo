package javajvm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class MyClassLoader extends ClassLoader {

    private final String classDir;

    public MyClassLoader(String classDir) {
        super(ClassLoader.getSystemClassLoader());
        this.classDir = classDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String classPath = classDir + "/" + name.replace('.', '/') + ".class";
            byte[] classBytes = Files.readAllBytes(Paths.get(classPath));

            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        }
    }
}
public class LoadClassDemo {
    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader("E:/SuanFaDemo/SuanFaDemo/myclasses");

        // 使用自定义类加载器加载类
        Class<?> clazz = classLoader.loadClass("demo.Hello");

        Object obj = clazz.getDeclaredConstructor().newInstance();

        clazz.getMethod("say").invoke(obj);

        // 打印类加载器
        System.out.println("ClassLoader: " + clazz.getClassLoader());
    }
}
