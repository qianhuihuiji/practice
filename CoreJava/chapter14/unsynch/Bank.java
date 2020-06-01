package CoreJava.chapter14.unsynch;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-05-31 23:36
 */
public class Bank {
    private Lock bankLock = new ReentrantLock();
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(this.accounts, initialBalance);
    }

    public void transfer(int from, int to, double amount)
    {
        bankLock.lock();

        try {
//            if(accounts[from] < amount) return;
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("From balance:%10.2f%n", accounts[from]);
            System.out.printf("%10.2f from %d to %d,", amount, from, to);
            accounts[to] += amount;
            System.out.printf("To balance:%10.2f%n", accounts[to]);
            System.out.printf("Total balance:%10.2f%n", getTotalBalance());
        } finally {
            bankLock.unlock();
        }
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
