package basicTool;

/*
匿名内部类，lambda表达式，函数式接口

匿名内部类: new一个接口，不给名字
函数式接口：只有一个方法的加了@FunctionalInterface注解的接口
 */
@FunctionalInterface
interface ImF{
    void hello(String name);
}
@FunctionalInterface
interface ImF2{
    String hello(String name);
}
@FunctionalInterface
interface ImF3{
    int add(int a,int b);
}
public class lambdaDemo {
    public static void main(String[] args) {

        //1
        ImF f1=new ImF() {
            @Override
            public void hello(String name) {
                System.out.println("Hello"+name);
            }
        };//new 的其实是一个匿名的ImF的实现类
        f1.hello("tt");
        ImF f2=(name -> System.out.println("Hello"+name));
        f2.hello("tt");
        //2
        ImF2 f3=new ImF2() {
            @Override
            public String hello(String name) {
                return "my_"+name;
            }
        };
        System.out.println(f3.hello("kk"));
        ImF2 f4=name->"mymy_"+name;
        System.out.println(f4.hello("kk"));

        ImF3 f5=(a,b)->(a+b);
        System.out.println(f5.add(1,2));





    }
}
