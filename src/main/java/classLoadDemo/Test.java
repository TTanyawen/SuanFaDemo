package classLoadDemo;

public class Test {

    public static void main(String[] args) throws Exception {

        MyClassLoader loader = new MyClassLoader();

        Class<?> c = loader.loadClass("java.lang.String");

        System.out.println(c);
        System.out.println(c.getClassLoader());

    }
}