package CoreJava.chapter9.linkedList;

import java.util.*;

/**
 * TODO
 *
 * @author nofirst
 * @since
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("David");
        b.add("Frank");
        b.add("Gloria");

        // merge the words from b to a
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if(aIter.hasNext()) aIter.next();

            aIter.add(bIter.next());
        }

        System.out.println(a);

        // remove every second word form b
        bIter = b.iterator();

        while (bIter.hasNext()) {
            bIter.next();

            if(bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);

        a.removeAll(b);

        System.out.println(a);
    }
}
