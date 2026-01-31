package basicTool;

public class InterfaceDemo2 {
    public static void main(String[] args) {
        A1 a=new C1();
    }
}
interface A1{
}
interface B1 extends A1{

}
class C1 implements B1{

}
