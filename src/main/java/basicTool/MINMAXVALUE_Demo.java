package basicTool;
/*
LONG的MAX_VALUE比Intger的MAX_VALUE大
LONG的MIN_VALUE比Intger的MIN_VALUE小
 */
public class MINMAXVALUE_Demo {
    public static void main(String[] args) {

        Long l=Long.MAX_VALUE;
        Integer i=Integer.MAX_VALUE;
        System.out.println(l);
        System.out.println(i);
        System.out.println(i<l);

        Long l2=Long.MIN_VALUE;
        Integer i2=Integer.MIN_VALUE;
        System.out.println(l2);
        System.out.println(i2);
        System.out.println(l2<i2);

    }
}
