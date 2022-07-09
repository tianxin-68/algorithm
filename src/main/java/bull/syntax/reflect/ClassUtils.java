package bull.syntax.reflect;

/**
 * @author: tianxin068
 * @date: 2022/7/9 10
 */
public class ClassUtils {

    public static <T> T getInstance(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String s = ClassUtils.getInstance(String.class);
    }
}
