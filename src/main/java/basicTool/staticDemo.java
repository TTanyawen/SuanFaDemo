package basicTool;

class staticCls{
    static {
        System.out.println("static代码块开始");

        System.out.println("static代码块结束");
    }
    public staticCls(){
        System.out.println("构造函数执行");
    }
}
public class staticDemo {
    public static void main(String[] args) {
        staticCls cls=new staticCls();
    }
}
