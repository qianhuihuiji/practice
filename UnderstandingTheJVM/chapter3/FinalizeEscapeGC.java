package UnderstandingTheJVM.chapter3;

/**
 * 此代码演示了2点：
 * 1.对象可以在被GC的时候自我拯救
 * 2.这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统执行一次
 *
 * @author nofirst
 * @date 2020-11-03 22:18
 */
public class FinalizeEscapeGC {
    private static FinalizeEscapeGC SAVE_HOOK =  null;

    public static void main(String[] args) throws Throwable{
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为 finalize() 方法优先级很低，所以暂停 0.5秒等它
        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }

        // 下面这段代码与上面完全相同，但是这次却失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为 finalize() 方法优先级很低，所以暂停 0.5秒等它
        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
    }

    private void isAlive() {
        System.out.println("yes,i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }
}
