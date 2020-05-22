package CoreJava.chapter9.map;


import CoreJava.chapter6.interfaces.Employee;

import java.util.*;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-05-22 16:26
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("1", new Employee("Amy Lee", 2000));
        staff.put("2", new Employee("Harry", 3000));
        staff.put("3", new Employee("Ccc", 4000));
        staff.put("4", new Employee("Ddd", 5000));

        Set<String> keys = staff.keySet();

        System.out.println(keys);
        System.out.println(staff);

        staff.remove("1");
        staff.put("4", new Employee("ddd", 5000));
        System.out.println(staff.get("1"));

        staff.forEach((k, v) -> System.out.println("key=" + k + ", name=" + v.getName()));
    }
}
