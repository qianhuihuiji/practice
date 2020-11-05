package UnderstandingTheJVM.chapter3;

/**
 * 参数：-verbose:gc -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728
 * PretenureSizeThreshold 参数只对 Serial 和 ParNew 收集器有效
 *
 * @author nofirst
 * @date 2020-11-03 22:18
 */
public class PretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Throwable {
        byte[] allocation;

        allocation = new byte[8 * _1MB];
    }
}
