package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/*
    completableFuture异常的处理
    .exceptionally()和.handle()
 */
public class CFDemo02 {
    private static final ThreadPoolExecutor executor=new ThreadPoolExecutor(
      2,4,60, TimeUnit.SECONDS,
      new LinkedBlockingDeque<>(10),
      r->{
          Thread t=new Thread(r);
          t.setName("ThreadId_"+t.getId());
          return t;
      },
      new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static void main(String[] args) {
        CompletableFuture<Integer> task1=CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+":task 1 started");
            int x=10/0;//异常
            return x;
        },executor);

        //没有执行了
        CompletableFuture<Integer> task2 = task1.thenApply(result -> {
            System.out.println(Thread.currentThread().getName() + ":task 2 started");
            return result * 2;
        });
        //前边有异常，这里就可以处理---exceptionally
        CompletableFuture<Integer> handled1 = task2.exceptionally(ex -> {
            System.out.println("exceptionally: " + ex.getMessage());
            return -1; //兜底
        });
        //成功失败都会执行的，类似finally
        CompletableFuture<String> handled2 = handled1.handle((res, ex) -> {
            if (ex != null) {
                return "handle error: " + ex.getMessage();
            } else {
                return "handle success: " + res;
            }
        });
        //记录,这里拿得到兜底的-1
        CompletableFuture<String> finalTask = handled2.whenComplete((res, ex) -> {
            System.out.println("whenComplete -> result: "+res +",ex: "+ ex);
        });
        try {
            String result = finalTask.get();
            System.out.println("res: "+result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
