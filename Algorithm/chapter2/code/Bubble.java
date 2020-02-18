package Algorithm.chapter2.code;

public class Bubble {
    public static void sort(Comparable[] a) {
        int N = a.length;

        for(int i = 0;i < N;i++)
        {
            boolean flag = false;
            for(int j = 0;j < N - 1 - i;j++)
            {
                if(less(a[j+1],a[j])) exch(a,j,j+1);
                flag = true;
            }

            if(! flag) break;
        }
    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
