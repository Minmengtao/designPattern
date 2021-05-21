package Singleton;

/**
 * 从头到尾只生成一个实例，故称为单例模式
 * 只要对象只能对一个实例进行操作，例如数据库当中的连接操作，只能对一个数据库操作，这个时候必须使用单例模式
 * @author minmengtao
 * @date 2020-5-12
 */
public class BankTest{
    public static void main(String[] args) {
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2);//return true;

        Bank1 b11 = Bank1.getInstance();
        Bank1 b12 = Bank1.getInstance();
        System.out.println(b11 == b12);//return true;

        Bank2 b21 = Bank2.getInstance();
        Bank2 b22 = Bank2.getInstance();
        System.out.println(b21 == b22);//return true;
    }
}
//内部类实现
class Bank2 {
    //延迟私有静态变量实例化
    //1.私有化构造器
    private Bank2() {
        //
    }
    //私有化内部类
    private static class BankHolder {
        private static final Bank2 INSTANCE = new Bank2();
    }

    //
    public static Bank2 getInstance() {
        return BankHolder.INSTANCE;
    }
}
//懒汉式，线程不安全，
class Bank1 {
    //延迟私有静态变量实例化
    //1.私有化构造器
    private Bank1() {
        //
    }

    //2.先不实例化
    private static Bank1 instance;

    //3.需要的时候才会实例化
    public static Bank1 getInstance() {
        if(instance == null) {
            instance = new Bank1();
        }
        return instance;
    }

    //4.为例保证方法线程安全，引入synchronized关键字，但是不推荐使用该方法
    public static synchronized Bank1 getInstance1() {
        if(instance == null) {
            instance = new Bank1();
        }
        return instance;
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