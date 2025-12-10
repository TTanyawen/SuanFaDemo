package basicTool;

public class IntegerDemo {
    public static void main(String[] args) {
        Integer i=Integer.valueOf(1);//使用静态缓存池中的对象赋值给引用
        Integer i2=new Integer(1);//新建一个对象
    }
}
