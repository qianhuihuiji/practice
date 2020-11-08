package UnderstandingTheJVM.chpater7;

/**
 *
 * @author nofirst
 * @date 2020-11-06 16:50
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORD = "hello world";
}


