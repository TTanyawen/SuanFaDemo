package designpattern;

/**
 * 单例模式
 * 1. 将构造方法变成private的
 * 2. 提供一个getInstance的静态方法能创建和获得对象
 * 3. 使用volatile static的instance字段存储对象
 */
class SingleTon1{
    private static volatile SingleTon1 instance=null;
    private SingleTon1(){}
    public static SingleTon1 getInstance(){
        if(instance==null){
            synchronized (SingleTon1.class){
                if(instance==null){
                    instance=new SingleTon1();
                }
            }
        }
        return instance;
    }
}
public class DanliDemo {
    public static void main(String[] args) {
        SingleTon1 s1=SingleTon1.getInstance();

        SingleTon1 s2=SingleTon1.getInstance();
        System.out.println(s1+","+s2);

    }
}
