package future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// 线程池提交任务会返回一个future对象
//  通过get可以拿到结果
// 可以通过设置最大等待时间避免一直阻塞等待结果
public class FutureDemo01 {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        // 提交一个有返回值的任务
        Future<Integer> future = pool.submit(() -> {
            System.out.println("任务开始执行...");
            Thread.sleep(2000);
            return 42;
        });

        System.out.println("主线程继续执行...");

        // 需要结果时再 get()
//        Integer result = future.get();
        Integer result = future.get(1, TimeUnit.MILLISECONDS);//设置最大等待时间
        System.out.println("任务执行结果：" + result);
        pool.shutdown();
    }
}
