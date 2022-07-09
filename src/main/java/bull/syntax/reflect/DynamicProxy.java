package bull.syntax.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.System.out;

/**
 * JDK动态代理工具参数：（1）类加载器 （2）该代理实现接口列表；（3）一个InvocationHandler实现
 *
 * @author: tianxin068
 * @date: 2022/7/9 10
 */
public class DynamicProxy {
    public static void main(String[] args) {
        Test proxy = (Test) Proxy
                .newProxyInstance(Test.class.getClassLoader(),
                        new Class[]{Test.class},
                        new DynamicProxyHandler(new QuickTest()));
        proxy.test();
    }
}

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        out.println("method" + method.getName() + " execute start ");
        method.invoke(proxied, args);
        long used = System.currentTimeMillis() - start;
        out.println("method " + proxied.getClass().getName() + "." + method.getName() + " execute end and use:" + used);
        return used;
    }
}