package edu.hust.se;

import org.junit.Test;

/**
 * 代理类和被代理类在编译期间都确定下来了
 */

interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory clothFactory;//用被代理类实例化

    public ProxyClothFactory(ClothFactory clothFactory){
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        clothFactory.produceCloth();
        System.out.println("produce finish");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println(" Nike produce cloth");
    }
}

public class StaticProxyTest {
    @Test
    public void test(){
        ClothFactory nike = new NikeClothFactory();//创建被代理对象

        ClothFactory proClothFactory = new ProxyClothFactory(nike);//创建代理对象

        proClothFactory.produceCloth();
    }
}
