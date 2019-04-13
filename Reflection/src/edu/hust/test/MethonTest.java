package edu.hust.test;

import edu.hust.cs.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class MethonTest {
    @Test
    public void test1(){
        Class clazz = Person.class;

        //获取当前运行时类及其父类中申明为public的方法(不包含构造器)
        Method[] ms = clazz.getMethods();
        for (Method m:ms) {
            System.out.println(m);
        }

        System.out.println("-----------------------");
        //获取当前类声明的所有方法(不包含父类的)
        Method[] mds = clazz.getDeclaredMethods();
        for (Method m:mds) {
            System.out.println(m);
        }
    }

    /**
     * 注解、方法权限修饰符、返回值类型、方法名（形参类型1 形参名1）throw Exception
     */
    @Test
    public void test2(){
        Class clazz = Person.class;

        //获取当前运行时类及其父类中申明为public的方法(不包含构造器)
        Method[] ms = clazz.getDeclaredMethods();
        for (Method m:ms) {
            Annotation[] annotations =  m.getAnnotations();
            for (Annotation an: annotations){
                System.out.println(an);
            }

            System.out.println(Modifier.toString(m.getModifiers()));

            System.out.println(m.getReturnType().getName());

            System.out.println(m.getName());

            //形参

            Class[] paraTypes = m.getParameterTypes();
            Parameter[] paraNames = m.getParameters();//jdk1.8开始支持拿name
            if(paraTypes!=null && paraTypes.length != 0) {
                for(int i = 0;i<paraTypes.length;i++) {
                    System.out.println(paraTypes[i].getName());
                    System.out.println(paraNames[i].getName());
                }
            }
            System.out.println("=============================");
        }

    }
}
