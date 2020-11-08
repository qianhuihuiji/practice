package UnderstandingTheJVM.chpater7;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与 instanceof 关键字演示
 *
 * @author nofirst
 * @date 2020-11-08 11:51
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass (String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);

                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("UnderstandingTheJVM.chpater7.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof UnderstandingTheJVM.chpater7.ClassLoaderTest);
    }
}
