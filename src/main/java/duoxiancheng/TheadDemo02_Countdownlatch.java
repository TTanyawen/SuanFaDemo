package duoxiancheng;

import java.util.concurrent.CountDownLatch;

public class TheadDemo02_Countdownlatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(3);
        for(int i=0;i<3;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 完成任务");
                latch.countDown();//计数减1
            }).start();

            System.out.println("主线程等待子线程完成...");
            latch.await();  // 等待 count=0
            System.out.println("所有线程已完成，主线程继续执行！");

        }
    }

}
