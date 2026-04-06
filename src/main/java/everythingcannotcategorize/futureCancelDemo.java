package everythingcannotcategorize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
    停止线程池里面的任务
    1. 响应中断的正在执行的任务
    2. 不响应中断的正在执行的任务
    3. 排队的任务
 */
public class futureCancelDemo {
    public static void main(String[] args) throws InterruptedException {
//        demo1();
//        demo2();
        demo3();
    }
    public static void demo1() throws InterruptedException {
        //响应中断的正在执行的任务
        /*
            step:0 步
            step:1 步
            step:2 步
            task is interrupted
            说明正在执行的任务只要响应中断，那么就可以停止任务了，cancel估计就是把interrupt标记成true了
         */
        ExecutorService executor= Executors.newFixedThreadPool(2);
        Future<?> future=executor.submit(()->{
            try{
                for (int i=0;i<10;i++) {
                    System.out.println("step:"+i +" 步");
                    Thread.sleep(1000);
                }
                System.out.println("task is done");
            }catch(InterruptedException e){
                System.out.println("task is interrupted");
            }
        });
        Thread.sleep(1000);
        future.cancel(true);
    }
    public static void demo2() throws InterruptedException {
        //不响应中断的正在执行任务
        /*
            可以看见task is interrupted有打印，但是线程没有停止，说明需要手动响应中断
         */
        ExecutorService executor= Executors.newFixedThreadPool(2);
        Future<?> future=executor.submit(()->{
            for (int i=0;i<10000000;i++) {
                System.out.println( "step:"+i +" 步");
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("task is interrupted");
                }
            }
        });
        Thread.sleep(1000);
        future.cancel(true);
    }
    public static void demo3() throws InterruptedException {
        //排队的任务
        /*
            可以发现task2在排队的时候就直接能被取消掉
         */
        ExecutorService executor= Executors.newSingleThreadExecutor();
        Future<?> future1=executor.submit(()->{
            System.out.println("task1 started");
            try{
                for(int i=0;i<10;i++){
                    Thread.sleep(1000);
                }
                System.out.println("task1 is done");
            }catch (InterruptedException e){
                System.out.println("task1 is interrupted");
            }
        });
        Future<?> future2=executor.submit(()->{
            System.out.println("task2 started");
            try{
                for(int i=0;i<10;i++){
                    Thread.sleep(1000);
                }
                System.out.println("task1 is done");
            }catch (InterruptedException e){
                System.out.println("task1 is interrupted");
            }
        });
        Thread.sleep(1000);
        future2.cancel(true);
        executor.shutdown();
    }
}
