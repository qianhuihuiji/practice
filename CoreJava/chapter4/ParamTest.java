package CoreJava.chapter4;

public class ParamTest {
    public static void main(String[] args) {
        /*
         * 方法不能修改数字类型的参数变量
         */
        System.out.println("Testing tripleValue:");
        double percent = 0;
        System.out.println("Before:percent=" + percent);

        tripleValue(percent);

        System.out.println("After:percent=" + percent);

        /*
         * 方法可以改变对象参数的状态
         */
        System.out.println("\nTesting tripleSalary:");
        Employee harry = new Employee("Harry",5000);
        System.out.println("Before:salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After:salary=" + harry.getSalary());

        /*
         * 方法不能让对象参数引用一个新的对象
         */
        System.out.println("\nTesting swap");
        Employee a = new Employee("Alice",7000);
        Employee b = new Employee("Bob",6000);
        System.out.println("Before:a=" + a.getName());
        System.out.println("Before:b=" + b.getName());
        swap(a,b);
        System.out.println("After:a=" + a.getName());
        System.out.println("After:b=" + b.getName());
    }

    public static  void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method:x=" + x);
    }

    public static void tripleSalary(Employee x)
    {
        x.raiseSalary(200);
        System.out.println("End of method:salary=" + x.getSalary());
    }

    public static void swap(Employee x,Employee y)
    {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method:x=" + x.getName());
        System.out.println("End of method:y=" + y.getName());
    }
}

class Employee
{
    private String name;
    private double salary;

    public Employee(String name,double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName()
    {
        return this.name;
    }

    public double getSalary()
    {
        return this.salary;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
}