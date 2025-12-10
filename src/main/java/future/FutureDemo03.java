package future;

import java.util.concurrent.*;

public class FutureDemo03 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool= Executors.newSingleThreadExecutor();
//        ExecutorService pool2= new ThreadPoolExecutor(100, Integer.MAX_VALUE,
//                60L, TimeUnit.SECONDS,
//                new SynchronousQueue<Runnable>());

        Future<?> future=pool.submit(()->{
           Thread.sleep(2000);
           return 123;
        });

        while (!future.isDone()) {
            System.out.println("任务还没完成，我继续做别的事...");
            Thread.sleep(500);
        }

        System.out.println("结果是：" + future.get());

    }
}
