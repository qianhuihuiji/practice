package UnderstandingTheJVM.chapter12;

/**
 * VolatileTest
 *
 * @author nofirst
 * @date 2020-11-18 21:04
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i=0;i < THREAD_COUNT;i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<10000;i++) {
                        increase();
                    }
                }
            });

            threads[i].start();
        }

        // idea 本身还有相关进程
        while (Thread.activeCount() > 3) Thread.yield();

        System.out.println(Thread.activeCount());
        System.out.println(race);
    }
}
