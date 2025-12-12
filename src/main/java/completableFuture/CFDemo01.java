package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CFDemo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //runAsync：异步执行+无结果
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("异步任务执行");
        });

        //supplyAsync：异步执行+有结果，get会阻塞拿结果
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 123;
        });

        System.out.println("前");
        System.out.println(future2.get());
        System.out.println("后");


        //thenApply  链式，通过一个future，thenApply控制几个操作的先后顺序形成处理连跳
        CompletableFuture<Integer> future3 =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenApply(x -> x * 2)
                        .thenApply(x -> x + 1);
        System.out.println(future.get()); // 21

        // thenAccept  链式  拿结果做一些事情
        CompletableFuture.supplyAsync(() -> 100)
                .thenAccept(result -> {
                    System.out.println("结果:" + result);
                });
        //thenRun 链式   不拿结果但是做一些后续处理
        CompletableFuture.supplyAsync(() -> 100)
                .thenRun(() -> System.out.println("任务完成"));

        //组合几个任务
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 1);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 2);
        CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(() -> 3);

        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
        all.join(); // 等全部任务结束

        System.out.println(f1.get() + f2.get() + f3.get());

        //exceptionally
        CompletableFuture<Integer> future4 =
                CompletableFuture.supplyAsync(() -> {
                    int i = 1 / 0;  // 报错
                    return 10;
                }).exceptionally(e -> {
                    System.out.println("出现异常：" + e.getMessage());
                    return 0;  // 发生异常后的默认值
                });

        System.out.println(future.get()); // 0


        // 类似finially的一个
        CompletableFuture<Integer> future5 =
                CompletableFuture.supplyAsync(() -> {
                    return 10 / 0;
                }).handle((res, ex) -> {
                    if (ex != null) {
                        System.out.println("异常：" + ex.getMessage());
                        return -1;
                    }
                    return res;
                });

        System.out.println(future.get()); // -1

        //主动完成任务
        CompletableFuture<String> future6 = new CompletableFuture<>();

        new Thread(() -> {
            try { Thread.sleep(2000); } catch (Exception ignore) {}
            future6.complete("手动完成！");
        }).start();

        System.out.println(future.get()); // 手动完成




    }
}
