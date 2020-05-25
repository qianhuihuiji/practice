package CoreJava.chapter9.sieve;

import java.util.BitSet;

/**
 * 首先将所有的
 * 位置为 开 状态，然后 将已知素数的倍数所对应的位都置为 关 状态
 * 经过这个操作，保留下来的 位 对应的就是素数
 *
 * @author nofirst
 * @date 2020-05-25 10:47
 */
public class Sieve {
    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n + 1);
        int count = 0;
        int i;
        // 设置所有「位」为开
        for(i = 2; i <= n; i++)
            b.set(i);

        i = 2;
        while (i * i <= n )
        {
            if(b.get(i))
            {
                count++;
                int k = 2 * i; // i 的 2 倍
                while (k <= n)
                {
                    b.clear(k);
                    k += i; // i 的 3、4、5... 倍
                }
            }

            i++;
        }

        while (i <= n) {
            if(b.get(i)) count++;
            i++;
        }

        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");
    }
}
