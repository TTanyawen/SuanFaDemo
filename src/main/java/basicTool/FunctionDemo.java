package basicTool;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
函数式接口
1. 自定义（定义只有一个方法的接口）
2. 现成有提供几个函数式接口
    无进无出 Runnable/Supplier<void>/Consumer<Void>
    有进无出 Consumer<T>/BiConsumer<T,U>
    无进有出 Supplier<T>
    有进有出 Function<T,R>/BiFunction<T,U,R>

 */
public class FunctionDemo {
    public static void main(String[] args) {
        Runnable f1=()->System.out.println("hello");
        f1.run();

        Consumer<String> f2=(s)->System.out.println("hello"+s);
        f2.accept("angela");

        Supplier<Integer> f3=()->100;
        System.out.println(f3.get());

        Function<Integer,Integer> f4=(i)->i*2;
        System.out.println(f4.apply(2));

        BiConsumer<Integer,Integer> f5=(i,j)->System.out.println("i+j="+(i+j));
        f5.accept(1,2);
    }
}
