package innerclass;

public class MyOuterClassTest {
    public static void main(String[] args) {
        f();
    }
    public static void f(){
        //可以独立实例化
        /*
        因为静态内部类本身就不需要拿到外部类的实例，不需要通过外部类的实例拿到外部类非静态的那些成员，所以它是可以单独做实例化的
         */
        MyOuterClass.MyStaticInnerClass myStaticInnerClass=new MyOuterClass.MyStaticInnerClass();
        myStaticInnerClass.show();

        //需要外部类实例化之后才能实例化
        /*
        因为内部类会绑定外部类，需要使用到外部类的非静态的成员，如果外部类没有实例化，就自然拿不到这些信息
        编译器会给非静态的内部类维护一个对外部类实例的引用
         */
        MyOuterClass myOuterClass=new MyOuterClass();
        MyOuterClass.MyInnerClass myInnerClass=myOuterClass.new MyInnerClass();
        myInnerClass.show();

        myOuterClass.init(myStaticInnerClass,myInnerClass);

        myOuterClass.f();


    }

}
class MyOuterClass{
    public int tag=10;
    public static int tag2=20;
    private static int tag3=30;
    MyInnerClass myInnerClass;
    MyStaticInnerClass myStaticInnerClass;
    public void init(MyStaticInnerClass myStaticInnerClass,MyInnerClass myInnerClass) {
        this.myInnerClass=myInnerClass;
        this.myStaticInnerClass=myStaticInnerClass;
    }
    public void f(){
        tag=100;
        tag2=200;
        myInnerClass.show();
        myStaticInnerClass.show();
    }
    class MyInnerClass{
        public void show(){
            System.out.println("show:"+ tag);
            System.out.println("show:"+ tag3);
        }
    }
    static class MyStaticInnerClass{

        void show(){
            System.out.println("show:"+ tag2);
            System.out.println("show:"+ tag3);//私有static也是ok的
            //静态内部类不可以访问外部类的非静态的成员
//            System.out.println("show:"+ tag);//Non-static field 'tag' cannot be referenced from a static context
        }
    }

}
