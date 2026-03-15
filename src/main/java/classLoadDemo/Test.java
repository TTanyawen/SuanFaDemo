package classLoadDemo;

public class Test {

    public static void main(String[] args) throws Exception {

//        MyClassLoader loader = new MyClassLoader();
//
//        Class<?> c = loader.loadClass("java.lang.String");
//
//        System.out.println(c);
//        System.out.println(c.getClassLoader());

        MyClassLoader1 loader1=new MyClassLoader1();
        Class<?> c1 = loader1.loadClass("classLoadDemo.MyClass");
        System.out.println(c1);
        System.out.println(c1.getClassLoader());

        MyClassLoader2 loader2=new MyClassLoader2();
        Class<?> c2 = loader2.loadClass("classLoadDemo.MyClass");
        System.out.println(c2);
        System.out.println(c2.getClassLoader());

    }
}