package CoreJava.chapter9.treeSet;

import java.util.*;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-05-22 10:30
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(
                Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
