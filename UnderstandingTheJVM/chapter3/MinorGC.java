package UnderstandingTheJVM.chapter3;

/**
 * 参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * @author nofirst
 * @date 2020-11-03 22:18
 */
public class MinorGC {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Throwable {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[_1MB];
        allocation2 = new byte[_1MB];
        allocation3 = new byte[_1MB];
        allocation4 = new byte[_1MB]; // 出现一次 Minor GC
    }
}
