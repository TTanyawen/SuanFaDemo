package proxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/*
    java原生动态代理
    1. 写接口，写接口实现类
    2. 写InvocationHandler的实现类，重写invoke方法
    3. 创建target，使用Proxy.newProxyInstance创建代理对象
        需要传入target的classLoader，target的接口，InvocationHandler的实现类对象


    适用于target类有接口的情况，如果没有接口就得用cglib
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        MyService2 target = new MyServiceImpl2();
        MyService2 proxy = (MyService2) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInvocationHandler(target));
        proxy.doSomething2();
    }
}
interface MyService2{
    void doSomething2();
}
class MyServiceImpl2 implements MyService2{
    @Override
    public void doSomething2() {
        System.out.println("doSomething2");
    }
}
class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before---");
        Object result = method.invoke(target, args);
        System.out.println("after---");
        return result;
    }
}