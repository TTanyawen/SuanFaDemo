package annotations;


public class MyAnnoTest {
    @MyAnno02(value="i")
    public int i=0;
    @MyAnno03(value="i2")
    public int i2=0;
    public static void main(String[] args) {
        myMethod();
        //反射拿到方法的注解
        /*
        运行时注解依赖反射实现解析，配合Class，Method，Field
        的getAnnotation，isAnnotationPresent方法
         */
        try {
            Class c=MyAnnoTest.class;
            MyAnno anno=c.getMethod("myMethod").getAnnotation(MyAnno.class);
            System.out.println(anno.str());
        }catch(Exception e){
            e.printStackTrace();
        }

        //反射拿到字段的注解，尝试拿retention是class级别的
        //拿不到，因为retention是class级别，字节码工具可以看见，运行时看不见
        try {
            Class c = MyAnnoTest.class;
            MyAnno02 anno = c.getField("i").getAnnotation(MyAnno02.class);
            System.out.println(anno.value());
        }catch(Exception e){
            e.printStackTrace();
        }

        //反射拿到字段的注解，尝试拿retention是runtime级别的
        //拿得到，可见runtime可以保留到运行时
        try {
            Class c = MyAnnoTest.class;
            MyAnno03 anno = c.getField("i2").getAnnotation(MyAnno03.class);
            System.out.println(anno.value());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @MyAnno(str = "k1")
    public static void myMethod() {}
}
