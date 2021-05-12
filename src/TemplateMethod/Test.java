package TemplateMethod;

/**
 * 模版方法模式
 * 将一些步骤的实现延迟到子类
 * 父类继承下两个子类
 * @author minmengtao
 * @date 2020-5-12
 */
public class Test {
    public static void main(String[] args) {
        CaffeineBeverage caffeineBeverage = new Coffee();
        caffeineBeverage.prepareRecipe();
        System.out.println("-----------");
        caffeineBeverage = new Tea();
        caffeineBeverage.prepareRecipe();
        /*
        boilWater
        Coffee.brew
        pourInCup
        Coffee.addCondiments
        -----------
        boilWater
        Tea.brew
        pourInCup
        Tea.addCondiments*/
    }
}
//创建冲咖啡和泡茶两种子类的父类
//为了能够复用两个子类的共同步骤，其他步骤在各自子类中实现
abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();//热水
        brew();//冲泡的动作
        pourInCup();//倒入杯子
        addCondiments();//添加调味料
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("boilWater");
    }

    void pourInCup() {
        System.out.println("pourInCup");
    }
}
class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Tea.brew");
    }

    @Override
    void addCondiments() {
        System.out.println("Tea.addCondiments");
    }
}
class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Coffee.brew");
    }

    @Override
    void addCondiments() {
        System.out.println("Coffee.addCondiments");
    }
}
