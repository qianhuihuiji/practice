package CoreJava.chapter14.unsynch;

import java.util.*;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-05-31 23:36
 */
public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(this.accounts, initialBalance);
    }

    public void transfer(int from, int to, double amount)
    {
        if(accounts[from] < amount) return;
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf("Total balance:%10.2f%n", getTotalBalance());
    }

    public double getTotalBalance() {
        double sum = 0;

        for (double account : accounts)
            sum += account;

        return sum;
    }

    public int size()
    {
        return accounts.length;
    }
}
