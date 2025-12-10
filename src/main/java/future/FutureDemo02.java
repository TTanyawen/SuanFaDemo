package future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
// cancel 尝试中断线程
// 线程会收到一个中断信号，如果此时线程再执行sleep(TIME_WAITING)/wait(WAITING/TIME_WAITING)/join(WAITING/TIME_WAITING)/等阻塞方法，方法被中断时候会抛InterruptedException，可以中断任务
// 其他情况，线程也可以在一个循环里面调用isTerrupted()
public class FutureDemo02 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<?> future=pool.submit(()->{
            while (true) {
                System.out.println("任务执行中...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("任务被中断！");
                    break;
                }
            }
        });

        Thread.sleep(1500);
        future.cancel(true); //true->允许中断正在运行的任务

        System.out.println("任务是否被取消: " + future.isCancelled());
    }
}
