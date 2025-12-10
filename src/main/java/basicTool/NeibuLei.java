package basicTool;

public class NeibuLei {
    public static void main(String[] args) {
        Outer outer=new Outer();
//        Outer.C01 c1=new Outer.C01();//不能脱离Outer实例化
        Outer.C02 c2=new Outer.C02();//可以脱离Outer实例化
                        // 因为静态内部类并不依赖Outer的非静态的变量和方法
    }
}
class Outer{
    int i;
    static int j;
    public void f1(){}
    public static void f2(){}
    class C01{
        public void func(){
            i=1;
            j=1;
            f1();
            f2();
        }
    }

    static class C02{
        public void func(){
//            i=1; //不能访问外部类的非静态的变量
            j=1;
//            f1();//不能访问外部类的非静态的方法
            f2();
        }
    }

}
