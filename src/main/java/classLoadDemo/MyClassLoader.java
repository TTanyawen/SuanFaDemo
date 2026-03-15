package classLoadDemo;

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass: " + name);
        return super.findClass(name);
    }

}
