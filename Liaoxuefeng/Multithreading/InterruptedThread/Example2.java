package Liaoxuefeng.Multithreading.InterruptedThread;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-06-18 10:18
 */
public class Example2 {
    public static void main(String[] args) throws InterruptedException{
        Thread t = new MyThread2();
        t.start();
        Thread.sleep(1000); // 暂停1000毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

class MyThread2 extends Thread{
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        System.out.println(hello.getState());

        System.out.println(hello.getState());
        try {
            Thread.sleep(3);
            System.out.println(hello.getState());
            System.out.println("t is waiting");
            Thread.sleep(3);
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        System.out.println(hello.getState());
        hello.interrupt();
    }
}

class HelloThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
//                break;
            }
        }
    }
}
