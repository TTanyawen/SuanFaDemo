package basicTool.concurrency_safety;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        //AtomicInteger提供了对前置后置的++和+=N 的原子性的操作
        ai.incrementAndGet();//相当于++i
        ai.addAndGet(2);
        ai.getAndAdd(2);
        ai.decrementAndGet();//相当于--i
        ai.getAndIncrement();//相当于i++
        ai.getAndDecrement();//相当于i--
        System.out.println(ai.get());

    }
}
