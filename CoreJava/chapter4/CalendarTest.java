package CoreJava.chapter4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalendarTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10,0.75f,true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);
        m.put(3, 26);
        m.get(5);
        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }

//        LocalDate date = LocalDate.now();
//        int month = date.getMonthValue();
//        int today = date.getDayOfMonth();
//
//        date = date.minusDays(today - 1);// Set to start of month
//        DayOfWeek weekday = date.getDayOfWeek();
//        int value = weekday.getValue();// 1=Monday
//
//        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
//
//        for(int i = 1;i < value; i++) {
//            System.out.print("    ");
//        }
//
//        while (date.getMonthValue() == month) {
//            System.out.printf("%3d", date.getDayOfMonth());
//            if(date.getDayOfMonth() == today)
//                System.out.print("*");
//            else
//                System.out.print(" ");
//            date = date.plusDays(1);
//            if(date.getDayOfWeek().getValue() == 1) System.out.println();
//        }
//        if(date.getDayOfWeek().getValue() != 1) System.out.println();
    }
}
