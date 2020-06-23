package Liaoxuefeng.Multithreading.UseCompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-06-22 10:58
 */
public class Example1 {
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Example1::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) ->
            System.out.println("price: " + result)
        );
        // 如果执行异常:
        cf.exceptionally((e) -> {
            System.out.println("执行失败");
            e.printStackTrace();
            return null;
        });
        System.out.println("主线程执行到此处");
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            // 这里线程停止的时间要比主线程停止的时间短，不然的话主线程会先退出，不会收到线程的回调
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.5) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}