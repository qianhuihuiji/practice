package Liaoxuefeng.Multithreading.UseCondition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-06-22 10:58
 */
public class Example1 {
    public static void main(String[] args) throws InterruptedException{
        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<>();
        for (int i=0; i<5; i++) {
            Thread t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        } catch (Exception e) {
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }

        Thread add = new Thread(() -> {
            for (int i=0; i<10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try { Thread.sleep(2000); } catch(InterruptedException e) {}
            }
        });

        add.start();
        add.join();
        Thread.sleep(100);

        for (Thread t : ts) {
            t.interrupt();
        }

    }
}

class TaskQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() throws InterruptedException{
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }

            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}