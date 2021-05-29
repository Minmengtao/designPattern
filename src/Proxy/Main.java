package Proxy;

/**
 * @author: minmengtao
 * @date: 2021/5/29
 */
//1.定义发送短信的接口
interface SmsService {
    String sendMessage(String message);
}
//2.实现发送短信的接口
class SmsServiceImpl implements SmsService {

    @Override
    public String sendMessage(String message) {
        System.out.println("send message: " + message);
        return message;
    }
}
//创建代理类并同样实现发送短信的接口
class SmsProxy implements SmsService {

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String sendMessage(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.sendMessage(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.sendMessage("Java");
        //smsService.sendMessage("Java");
    }
}
