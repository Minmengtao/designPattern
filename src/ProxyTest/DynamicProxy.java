package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: minmengtao
 * @date: 2021/6/16
 */
interface SendMesService {
    String send(String message);
}
class SendMesServiceImpl implements SendMesService {

    @Override
    public String send(String message) {
        System.out.println("send essage:" + message);
        return message;
    }
}
class DebugInvocationHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException, InvocationTargetException {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
}
class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}
public class DynamicProxy {
    public static void main(String[] args) {
        SendMesService smsService = (SendMesService) JdkProxyFactory.getProxy(new SendMesServiceImpl());
        smsService.send("java");
    }
}