package designpattern;
/*
适配器模式：加一个类来做包装，并实现接口，串联起两个不适配的类/接口
 */
interface Target{
    void f();
}

//Adaptee想要使用Target::f,但是没办法
class Adaptee{

}

//多写一个类来适配
class Adaptor implements Target{
    private final Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f() {

    }
}
public class ShiPeiQiPatternDemo {
    public static void main(String[] args) {
        Adaptee adaptee=new Adaptee();
        Target target=new Adaptor(adaptee);
        target.f();
    }
}
