package classLoadDemo;

import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader2 extends ClassLoader{
    private String path = "E:/SuanFaDemo/SuanFaDemo/myclasses/";
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("MyClassLoader2-findClass: " + name);
        try {

            String filePath = path + name.replace(".", "/") + ".class";
            System.out.println(filePath);
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));

            return defineClass(name, bytes, 0, bytes.length);

        } catch (Exception e) {
            throw new ClassNotFoundException(name);
        }
    }

}
