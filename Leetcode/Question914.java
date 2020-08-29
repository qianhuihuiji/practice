package Leetcode;


public class Question914 {
    public static void main(String[] args) {
        int [] arr = {1,1,1,1,2,2,2,2,2,2,3,3,3};

        boolean answer = hasGroupsSizeX(arr);

        System.out.println(answer);
    }

    private static boolean hasGroupsSizeX(int[] deck) {
//        Map<Integer, Integer> dict = new HashMap<>();
//        // 构建lookup
//        for (int a : deck) {
//            int count = dict.getOrDefault(a, 0) + 1;
//            dict.put(a, count);
//        }

        // 用下面这种计数数组代替
        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            // 计数数组里面的值大于 0 ，说明是 deck 里面的元素
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }

    private static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}