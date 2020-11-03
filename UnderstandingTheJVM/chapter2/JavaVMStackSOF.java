package UnderstandingTheJVM.chapter2;

/**
 * VM Args: -Xss256k
 *
 * @author nofirst
 * @date 2020-11-03 21:08
 */
public class JavaVMStackSOF {
    private int stackLength = -1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
