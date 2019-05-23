package edu.hust.se;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{
    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like " + food);
    }
}

class ProcyFactory{
    public static Object getProxyInstance(Object obj){//obj:被代理类的对象
        MyInvocationHandler hanler = new MyInvocationHandler();
        hanler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),hanler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//被代理类的对象赋值
    public void bind(Object obj){
        this.obj = obj;
    }
    //通过代理类调用被代理类的方法时，会自动调用该invoke方法,所以可以将代理类的逻辑写在invoke中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * 注意形参中的proxy为代理类的对象，而method需要的是被代理类的对象
         */
        System.out.println("proxy' logic");
        return method.invoke(obj,args);
    }
}


public class DynamicProxyTest {

    public static void main(String[] args) {
        Human superMan = new SuperMan();
        Human proxy= (Human) ProcyFactory.getProxyInstance(superMan);
        proxy.eat("rise");
    }
}
