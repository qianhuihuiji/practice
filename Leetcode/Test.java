package Leetcode;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        int [] testArr = {2, 7, 11, 15};

        // 打印所有数组元素
//        for (int a : testArr) {
//            System.out.println(a);
//        }

        int i = 0;
//        System.out.println(++i);

        List<String> staff = new LinkedList<>();
        staff.add("Aaa");
        staff.add("Bbb");
        staff.add("Ccc");

        ListIterator<String> iter1 = staff.listIterator();
        ListIterator<String> iter2 = staff.listIterator();

        iter1.next();
        iter1.remove();
        iter2.next();
    }


    private void bfs(int t,int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.poll();
    }

}