package everythingcannotcategorize;

/*
可变参数
 */
public class VaryLengthParm {
    public static void main(String[] args) {
        test(3,1,2,3);
    }

    /**
     * 可变参数,本质上就是一个数组
     * @param a
     * @param b
     */
    public static void test(int a,int... b){
        System.out.println(a);
        for (int i : b) {
            System.out.println(i);
        }
        System.out.println(b.length);

    }
    /*
    这样是不行的：Vararg parameter must be the last in the list
     */
//    public static void test2(int... b,String a){
//        System.out.println(a);
//        for (int i : b) {
//            System.out.println(i);
//        }
//        System.out.println(b.length);
//
//    }
}
