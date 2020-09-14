package Geektime.JavaInterview.Episode19;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierSample
 *
 * @author nofirst
 * @date 2020-08-10 21:30
 */
public class CyclicBarrierSample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("Action...GO again!Reset parties to 5!");
            }
        });

        // 5 个线程，每个线程打印 3 次
        // 每打印 1 次，就会进入等待，直到 barrier 被重置，再次打印
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new CyclicWorker(barrier));
            t.start();
        }
    }

    static class CyclicWorker implements Runnable {
        private CyclicBarrier barrier;
        public CyclicWorker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                for (int i=0; i<3 ; i++){
                    System.out.println(Thread.currentThread().getName() + " Executed!,print:" + i);
                    barrier.await();
                }
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
