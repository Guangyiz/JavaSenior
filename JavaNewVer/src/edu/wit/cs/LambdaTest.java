package edu.wit.cs;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * 1.举例：(o1,o2)（lambda形参列表，就是接口抽象方法的形参列表）->（lambda操作符或箭头操作符）o1.compareTo(o2)（lambda,就是重写抽象方法的方法体）
 *
 *lambda表达式的使用（分为下面6中情况介绍）
 *本质：（函数式接口的实例）
 * 函数式接口:只包含一个抽象方法的接口，称为函数式接口
 */
public class LambdaTest {
    @Test
    public void test(){
        //无参，无返回值
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I like you");
            }
        };
        r1.run();
        System.out.println("--------");

        Runnable r2 = ()-> {System.out.println("I like she");};
        r2.run();
    }

    //一个参数，没有返回值
    @Test
    public void test1(){
         Consumer<String> con = new Consumer<String>() {
             @Override
             public void accept(String s) {
                 System.out.println(s);
             }

         };
         con.accept("一个参数，没有返回值");
         System.out.println("--------");

         Consumer<String> con1 = (String s)->{
             System.out.println(s);
         };
         con1.accept("一个参数，没有返回值");
     }

     //数据类型可以省略，编译器会自动推断，称为“类型推断”
     @Test
     public void test2(){
         Consumer<String> con1 = (s)->{
             System.out.println(s);
         };
         con1.accept("一个参数，没有返回值");
     }

     //只有一个参数，可以省略小括号
    @Test
    public void test3(){
        Consumer<String> con1 = s->{
            System.out.println(s);
        };
        con1.accept("一个参数，没有返回值");
    }

    //两个或以上参数，多条执行语句，有返回值
    @Test
    public void test4(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1+o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,24));
        System.out.println("------------");
        Comparator<Integer> com2 = (o1,o2)->{
            System.out.println(o1+o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12,24));
    }

    //方法体只有一条语句，return与大括号若有，都可以省略
    @Test
    public void test5(){
        Comparator<Integer> com2 = (o1,o2)->o1.compareTo(o2);//
        System.out.println(com2.compare(12,24));
    }

}
