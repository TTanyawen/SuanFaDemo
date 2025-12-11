package basicTool.interf;

/*
1. jdk8抽象类可以定义哪些方法
        什么都不加默认是public abstract
        default方法
        static方法
   哪些不可以
        private(jdk9 允许，供接口内部使用)


 */
interface Itf{
    int i=0;//默认是加public static final关键字的常量
    //默认是public abstract
    void f1();

    //default方法，实现类可以重写，不重写就用默认实现
    default void f2(){
        System.out.println("Itf default f2()");
    }

    //private jdk1.9被允许
//    private void f3();

    //static方法，跟随接口，可以通过接口调用
    static void f4(){
        System.out.println("Itf default f4()");
    }

}
class ShiX implements Itf{

    @Override
    public void f1() {

    }


}
public class InterfaceDemo {
    public static void main(String[] args) {
        ShiX shix=new ShiX();


//        shix.f4();//static方法不能通过实现类调用
        Itf.f4();//static方法通过类调用

    }

}
