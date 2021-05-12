package Singleton;

public class BankTest{
    public static void main(String[] args) {
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2);
    }
}
//饿汉式构建单例模式，线程安全
class Bank {
    //1.私有化构造器
    private Bank() {
        //
    }

    //2.私有化一个实例
    //4.静态化instance
    private static Bank instance = new Bank();

    //3.返回实例，类名直接调用需要静态化
    public static Bank getInstance() {
        return instance;
    }
}