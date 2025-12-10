package duoxiancheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo04 {
    static int i=0;
    public static void main(String[] args) {

        ExecutorService pool= Executors.newFixedThreadPool(5);
        for(int j=0;j<5;j++){
            pool.submit(()->{
                System.out.println(i);
                i++;
            });
        }
        ExecutorService pool2= Executors.newCachedThreadPool();
        ExecutorService pool3= Executors.newSingleThreadExecutor();
        ExecutorService pool4= Executors.newScheduledThreadPool(5);

    }
}
