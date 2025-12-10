package basicTool;

public class TypeDemo {
    public static void main(String[] args) {
        int i=128;
        //补码：00000000 00000000 00000000 10000000
        byte b=(byte)i;//byte 1字节，8位，
        //补码：10000000 (-128)
        System.out.println(b);

        int i2=300;
        //补码：00000000 00000000 00000001 00101100
        byte b2=(byte)i2;//byte 1字节，8位，
        //补码：00101100 ->原码=00101100(44)
        System.out.println(b2);
    }
}
