package CoreJava.chapter14.future;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-06-02 13:24
 */
public class FutureTest {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory:");
            String directory = in.nextLine();
            System.out.println("Enter keyword");
            String keyword = in.nextLine();

            MathCounter counter = new MathCounter(new File(directory), keyword);
            FutureTask<Integer> task = new FutureTask<>(counter);
            Thread t = new Thread(task);
            System.out.println("I am a thread:" + t.getName());
            t.start();

            try {
                System.out.println(task.get() + " matching files.");
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {

            }
        }
    }
}

class MathCounter implements Callable<Integer>
{
    private File directory;
    private String keyword;

    public MathCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    public Integer call() {
        int count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();

            for (File file : files) {
                if (file.isDirectory()) {
                    MathCounter counter = new MathCounter(file, keyword);
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    System.out.println("I am a thread:" + t.getName() + ",handle:" + file.getName());
                    t.start();
                } else {
                    if (search(file)) count++;
                }
            }

            for (Future<Integer> result : results) {
                try {
                    count += result.get();
                } catch (ExecutionException e) {

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