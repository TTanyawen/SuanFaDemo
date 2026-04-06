package proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
    cglib 动态代理
1. 写target类
2. 写MethodInterceptor实现类，实现getProxy和intercept方法
3. 使用：new CglibProxy(target).getProxy() 创建代理对象

 内部其实是创建了一个enhancer也就是target类的子类

 */
public class DynamicProxyDemo_CGLIB {
    public static void main(String[] args) {
        MyService3 target = new MyService3();
        MyService3 proxy=(MyService3)new CglibProxy(target).getProxy();
        proxy.doSomething3();

    }
}

class MyService3{
    public void doSomething3() {
        System.out.println("doSomething3");
    }
}
class CglibProxy implements MethodInterceptor {
    private Object target;
    public CglibProxy(Object target){
        this.target=target;
    }
    public Object getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before---");
        Object result = method.invoke(target, objects);
        System.out.println("after---");
        return result;
    }
}