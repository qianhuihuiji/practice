package CoreJava.chapter14.unsynch;

//import CoreJava.chapter14.synch.Bank;
import CoreJava.chapter14.synch2.Bank;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-05-31 23:36
 */
public class UnsynchBankTest {
    public static final int NACCOUNT = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final int MAX_ACCOUNT = 1000;
    public static final int DELAY = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNT, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNT; i ++)
        {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true)
                    {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_ACCOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep(DELAY);
                    }
                } catch (InterruptedException e) {
                }
            };

            Thread t = new Thread(r);
            t.start();
        }
    }
}
