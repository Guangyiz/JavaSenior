package edu.hust.test;

import edu.hust.cs.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性
 */
public class FieldTest {
    @Test
    public  void  test1(){
        Class clazz = Person.class;

        //获取当前运行时类及其父类中申明为public的属性
        Field[] fields = clazz.getFields();
        for (Field field:fields) {
            System.out.println(field);
        }

        //获取当前类声明的所有属性(不包含父类的)
        Field[] declarefields = clazz.getDeclaredFields();
        for (Field field:declarefields) {
            System.out.println(field);
        }
    }

    //属性的权限修饰符 数据类型 变量名
    @Test
    public  void test2(){
        Class clazz = Person.class;

        Field[] declarefields = clazz.getDeclaredFields();
        for (Field field:declarefields) {
            int modifier = field.getModifiers();//public :1 private:2
            System.out.println(Modifier.toString(modifier));

            Class type = field.getType();
            System.out.println(type.getName());

            String name = field.getName();
            System.out.println(name);
        }
    }
}
