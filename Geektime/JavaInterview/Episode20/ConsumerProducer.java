package Geektime.JavaInterview.Episode20;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 利用队列
 *
 * @author nofirst
 * @date 2020-08-11 10:02
 */
public class ConsumerProducer {
    public static final String EXIT_MSG = "Good bye!";

    public static void main(String[] args) {
        // 使用较小的队列，以更好地在输出中展示其影响
        // 容量为 3，说明生产者生产时队列的数量最大为 3 ，无论生产者生产速度多快
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        Producer producer1 = new Producer(queue, "P1");
        Producer producer2 = new Producer(queue, "P2");
        Consumer consumer = new Consumer(queue);

        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(consumer).start();
    }

    static class Producer implements Runnable {
        private BlockingQueue<String> queue;
        private String name;

        public Producer(BlockingQueue<String> queue, String name) {
            this.queue = queue;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(5L);
                    String msg = "Message" + i;
                    queue.put(msg);
                    System.out.println(this.name +  " Produced new item: " + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println("Time to say good bye!");
                queue.put(EXIT_MSG);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                String msg;
                while (! EXIT_MSG.equalsIgnoreCase((msg = queue.take()))) {
                    System.out.println("Consumed item: " + msg);
                    Thread.sleep(1000L);
                }

                System.out.println("Got exit message, bye!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
