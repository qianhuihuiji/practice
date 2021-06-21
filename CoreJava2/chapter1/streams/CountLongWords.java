package CoreJava2.chapter1.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(
                Paths.get("/Users/emenmei/Code/practice/practice/CoreJava2/chapter1/streams/alice30.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split(";"));

        long count = 0;
        for (String word : words) {
            if (word.length() > 12) count++;
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}
