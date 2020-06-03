package CoreJava.chapter14.threadPool;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;


/**
 * TODO
 *
 * @author nofirst
 * @date 2020-06-03 11:11
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory:");
            String directory = in.nextLine();
            System.out.println("Enter keyword:");
            String keyword = in.nextLine();

            ExecutorService pool = Executors.newCachedThreadPool();

            MathCounter counter = new MathCounter(new File(directory), keyword, pool);
            Future<Integer> result = pool.submit(counter);

            try {
                System.out.println(result.get() + " matching files.");
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {

            }

            pool.shutdown();

            int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("largest pool size=" + largestPoolSize);
        }
    }
}

class MathCounter implements Callable<Integer>
{
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MathCounter(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    public Integer call() {
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();

            for (File file : files) {
                if (file.isDirectory()) {
                    MathCounter counter = new MathCounter(file, keyword, pool);

                    Future<Integer> result = pool.submit(counter);

                    results.add(result);
                } else {
                    if (search(file)) count++;
                }
            }

            for (Future<Integer> result : results) {
                try {
                    count += result.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return count;
    }

    private boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file, "UTF-8")) {
                boolean found = false;
                while (! found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) found = true;
                }

                return found;
            }
        } catch (IOException e) {
            return false;
        }
    }
}
