package edu.wit.cs;

import org.junit.Test;

public class StringTest {
    @Test
    public void test(){
        String s1 = "javaEE";//字面量方式赋值,在方法区的字符串常量池中

        String s2 = new String("javaEE");//构造器方式，此时s2保存的是在堆中开辟空间对应的地址，String中的value属性指向字符串常量池
    }
}
