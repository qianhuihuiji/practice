package CoreJava.chapter14.synch;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-05-31 23:36
 */
public class Bank {
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();
    private Condition sufficientFounds;

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(this.accounts, initialBalance);
        this.bankLock = new ReentrantLock();
        this.sufficientFounds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException
    {
        bankLock.lock();

        try {
            while (accounts[from] < amount) {
                System.out.println(Thread.currentThread() + " is Waiting!");
                sufficientFounds.await();
            }

            System.out.print(Thread.currentThread());

            accounts[from] -= amount;
            System.out.printf(" From balance:%10.2f%n", accounts[from]);
            System.out.printf("%10.2f from %d to %d,", amount, from, to);
            accounts[to] += amount;
            System.out.printf("To balance:%10.2f%n", accounts[to]);
            System.out.printf("Total balance:%10.2f%n", getTotalBalance());

            sufficientFounds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        bankLock.lock();

        try {
            double sum = 0;

            for (double account : accounts)
                sum += account;
            return sum;
        }
        finally {
            bankLock.unlock();
        }

    }

    public int size()
    {
        return accounts.length;
    }
}
