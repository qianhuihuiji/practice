package CoreJava.chapter9.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-05-25 09:58
 */
public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 49; i++)
            numbers.add(i);
        Collections.shuffle(numbers);

        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);

        System.out.println(winningCombination);
    }
}
