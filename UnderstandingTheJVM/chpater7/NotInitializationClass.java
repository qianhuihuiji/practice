package UnderstandingTheJVM.chpater7;

/**
 * 被动引用示例
 *
 * @author nofirst
 * @date 2020-11-06 16:50
 */
public class NotInitializationClass{
    public static void main(String[] args) {
        // 会输出 SuperClass init!，而不会输出 SubClass init!
        // 对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过子类来引用父类定义的静态字段，只会触发父类的初始化
        System.out.println(SubClass.value);

        // 通过数组定义来引用类，不会触发此类的初始化
        SuperClass[] sca = new SuperClass[10];

        // 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
        System.out.println(ConstClass.HELLOWORD);
    }
}


