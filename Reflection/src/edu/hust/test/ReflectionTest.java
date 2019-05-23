package edu.hust.test;

import edu.hust.cs.Person;
import org.junit.Test;

import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test() throws Exception {
        Class clazz = Person.class;

        Person p = (Person) clazz.newInstance();

        Method m = clazz.getDeclaredMethod("showNation",String.class);

        m.setAccessible(true);
        Object returnparam= m.invoke(p,"CHN");
        System.out.println(returnparam);

        System.out.println("-------------");


        /**
         * 调用静态方法
         */
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);

        Object returnVal = showDesc.invoke(Person.class);
        System.out.println(returnVal);//void返回null




    }
}
