package Geektime.JavaInterview.Episode19;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreSample
 * 单个发放令牌，有一个放一个
 *
 * @author nofirst
 * @date 2020-08-10 17:14
 */
public class UsualSemaphoreSample {
    public static void main(String[] args) {
        System.out.println("Action...Go!");
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new SemaphoreWorker(semaphore));
            t.start();
        }
    }
}

class SemaphoreWorker implements Runnable {
    private String name;
    private Semaphore semaphore;

    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            log("is waiting for permit!");
            semaphore.acquire();
            log("acquired a permit!");
            log("executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log("released a permit");
            semaphore.release();
        }
    }

    private void log(String msg){
        if (name == null) {
            name = Thread.currentThread().getName();
        }
        System.out.println(name + " " + msg);
    }
}