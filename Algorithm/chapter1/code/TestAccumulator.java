package Algorithm.chapter1.code;

import Algorithm.common.StdOut;
import Algorithm.common.StdRandom;

public class TestAccumulator
{
    public static void main(String[] args)
    {
        int T = Integer.parseInt(args[0]);
        Accumulator a = new Accumulator();

        for (int t = 0; t < T; t++){
            a.addDataValue(StdRandom.uniform());
        }
            
        StdOut.println(a);
    }
}