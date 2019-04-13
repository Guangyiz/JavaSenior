package edu.hust.test;

import edu.hust.cs.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;

public class OtherTest {
    @Test
    public void test1() {
        Class clazz = Person.class;

        Class[] is = clazz.getInterfaces();
        for (Class i : is) {
            System.out.println(i);
        }

        //包名
        Package pack = clazz.getPackage();
        System.out.println(pack);

        //注解
        Annotation[] ans = clazz.getAnnotations();
        for(Annotation an :ans){
            System.out.println(an);
        }

    }
}
