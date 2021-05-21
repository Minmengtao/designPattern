package SimpleFactory;

/**
 * 简单工厂：在创建一个对象时不想客户暴露内部细节，并提供一个创建对象的通用接口
 * 让简单工厂类来决定实例化
 *
 * @author: minmengtao
 * @date: 2021/5/21
 */
public class Client {
    //本来选择实例化的放这里，但是为了不让客户知道有哪些子类以及子类内部的实现
    //使用简单工厂模式
    SimpleFactory simpleFactory = new SimpleFactory();
    Product product = simpleFactory.createProduct(1);
    //do something with the product
}
interface Product {

}
class ConcreteProduct implements Product {
}
class ConcreteProduct1 implements Product {
}
class ConcreteProduct2 implements Product {
}
class SimpleFactory {
    public Product createProduct(int type) {
        if(type == 1) {
            return new ConcreteProduct1();
        } else if(type == 2) {
            return new ConcreteProduct2();
        }
        return new ConcreteProduct();
    }
}