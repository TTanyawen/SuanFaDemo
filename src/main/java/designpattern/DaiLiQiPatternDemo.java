package designpattern;
/*
代理器模式，拦截下来让Proxy类帮忙调用并额外做点别的事情
 */
class A{
    public void f(){
        System.out.println("A: f()");
    }
}
class A_Proxy{
    A a;

    public A_Proxy(A a) {
        this.a = a;
    }

    public void f(){
        System.out.println("A_Proxy:Before A f()");
        a.f();
        System.out.println("A_Proxy:After A f()");
    }
}
public class DaiLiQiPatternDemo {
    public static void main(String[] args) {
        A a=new A();
        A_Proxy aProxy=new A_Proxy(a);
        aProxy.f();
    }
}
