package basicTool.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomDemo {

    static class MyObject {
        String name;

        MyObject(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {

        ReferenceQueue<MyObject> queue = new ReferenceQueue<>();
        MyObject obj = new MyObject("task-object");

        PhantomReference<MyObject> phantom =
                new PhantomReference<>(obj, queue);

        // 启动监听线程
        new Thread(() -> {
            while (true) {
                try {
                    PhantomReference<?> ref =
                            (PhantomReference<?>) queue.remove();

                    System.out.println("对象准备被GC，执行清理逻辑");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        obj = null;
        System.gc();
        Thread.sleep(3000);
    }
}
