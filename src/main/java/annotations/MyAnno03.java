package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
source 仅仅在源java文件
class 保留到.class
runtime 保留到运行时,可以反射读取，.class里面也看得见
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MyAnno03 {
    String value();
}
