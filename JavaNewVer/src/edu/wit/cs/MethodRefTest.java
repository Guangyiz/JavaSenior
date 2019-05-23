package edu.wit.cs;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 方法引用的使用：本质上就是lambda表达式
 * 使用格式：
 * 类（或对象）::方法名
 *
 * 1对象::非静态方法
 * 2类::静态方法
 * 3类::非静态方法
 *
 * 当要传递给lambda体的操作，已经有实现的方法了，可以使用方法引用
 * 要求：接口中的抽象方法的形参列表和返回值类型与方法引用的方法相同（针对上面的情况1和2）
 */
public class MethodRefTest {
    //对象::非静态方法
    @Test
    public void test(){
        //使用一：对象::实例对象
        Consumer<String> con1 = str-> System.out.println(str);
        con1.accept("北京");
        System.out.println("------------");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("beijing");
    }

    //类::静态方法
    @Test
    public void test1(){
        //使用一：对象::实例对象
        Comparator<Integer> com1 = (t1,t2)->Integer.compare(t1,t2);
        System.out.println(com1.compare(1,2));
        System.out.println("------------");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(1,2));
    }

    //类::非静态方法

    @Test
    public void test2(){
        Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc","abd"));
        System.out.println("--------");
        Comparator<String> com2 = String::compareTo;//其中一个参数作为调用者
        System.out.println(com2.compare("abc","abd"));

;    }


}
