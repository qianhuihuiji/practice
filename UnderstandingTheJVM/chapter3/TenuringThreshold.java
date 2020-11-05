package UnderstandingTheJVM.chapter3;

/**
 * 参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution -XX:+UseConcMarkSweepGC
 * 分别设置 MaxTenuringThreshold=1 和 MaxTenuringThreshold=15
 *
 * @author nofirst
 * @date 2020-11-03 22:18
 */
public class TenuringThreshold {
    private static final int _1MB = 1024 * 1024;


    @SuppressWarnings("unused")
    public static void main(String[] args) throws Throwable {
        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1MB / 4];

        // 什么时候进入老年代取决于 MaxTenuringThreshold 的设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];

        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
