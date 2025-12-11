package basicTool.abtract;
/*
1. 抽象类不能被实例化
2. 抽象类可以有不实现的方法(要加abstract关键字)
3. 抽象类可以有构造方法，但是它不能被实例化
 */

abstract class AbsClass{
    public AbsClass(){//抽象类可以有构造方法，但是它不能被实例化

    }
    int i;//变量
    public abstract void f2abs();//抽象方法，子类必须实现
    public void f1() {//普通方法，子类可以继承
        i=1;
        System.out.println("AbsClass f1");
    }
}
class NornalCls extends AbsClass{
    public NornalCls(){
        super();//调用抽象类的构造器
    }

    @Override
    public void f2abs() {
        System.out.println("NornalCls f2abs");
    }
    @Override
    public void f1() {//子类重写这个方法
        System.out.println("NornalCls f1");
    }
}

public class AbstactDemo {
    public static void main(String[] args) {

    }
}
