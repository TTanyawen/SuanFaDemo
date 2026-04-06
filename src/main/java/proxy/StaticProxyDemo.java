package proxy;

import java.lang.reflect.Proxy;
/*
    静态代理：自己去写代码维护代理和目标对象的关系，强耦合
        需要自己写代理类

    如果是动态代理，代理类是运行时生成的，不需要你自己写，依赖java原生的proxy或者cglib(一个字节码生成工具 code generation library )可以实现
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        MyService target = new MyServiceImpl();
        MyService proxy = new MyServiceProxy(target);
        proxy.doSomething();
    }
}
interface MyService{
    void doSomething();
}
class MyServiceImpl implements MyService{
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }
}
class MyServiceProxy implements MyService{
    private MyService myService;
    public MyServiceProxy(MyService myService){
        this.myService=myService;
    }
    @Override
    public void doSomething() {
        System.out.println("before---");
        myService.doSomething();
        System.out.println("after---");
    }
}
