package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
    RETENTION 指定生命周期
    source 仅仅在源java文件
    class 保留到.class
    runtime 保留到运行时,可以反射读取，.class里面也看得见
 */

/*
    TARGET
    ElementType.FIELD  成员变量，枚举常量
    ElementType.METHOD 成员方法
    ElementType.TYPE  类,接口，枚举
    ElementType.CONSTRUCTOR 构造方法
    ElementType.PARAMETER 方法参数
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface MyAnno02 {
    String value();
}
