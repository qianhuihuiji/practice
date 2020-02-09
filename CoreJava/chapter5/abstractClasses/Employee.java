package CoreJava.chapter5.abstractClasses;

import java.time.*;

public class Employee extends Person{
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day)
    {
        // 调用 Person 类的构造方法
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }

    public double getSalary()
    {
        return salary;
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    public String getDescription()
    {
        return String.format("an employee with salary of $%.2f",salary);
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
