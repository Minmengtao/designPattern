package FactoryMethod;

/**
 * @author: minmengtao
 * @date: 2021/5/21
 */
public abstract class Factory {
    abstract public Product factoryMethod();
    public void doSomething() {
        Product product = factoryMethod();
        // do something with the product
    }
}

interface Product {

}
class ConcreteProduct implements Product {
}
class ConcreteProduct1 implements Product {
}
class ConcreteProduct2 implements Product {
}
class ConcreteFactory extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
class ConcreteFactory1 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
class ConcreteFactory2 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}
