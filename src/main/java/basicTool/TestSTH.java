package basicTool;

/**
 * Integer通过直接Integer i=1;这种形式创建使用的是静态缓存池中的现成的对象
 * 通过valueOf创建也是使用的是静态缓存池中的现成的对象
 *
 * 但是通过new创建的话就是新new出来的一个对象在堆里头
 */
public class TestSTH {
    public static void main(String[] args) {
        Integer i=1;
        Integer i1=1;
        System.out.println(i==i1);

        Integer i2=new Integer(1);
        Integer i3=new Integer(2);
        System.out.println(i2==i3);

        Integer i4=Integer.valueOf(1);
        Integer i5=Integer.valueOf(1);
        System.out.println(i4==i5);
        System.out.println(i4==i);
    }
}
