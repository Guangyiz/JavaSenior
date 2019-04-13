package edu.hust.se;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest {
    //反射之前，对于Person的操作
    @Test
    public void test1(){
        Person p1 = new Person("Tom",12);

        p1.age = 10;
        System.out.println(p1.toString());
        p1.show();
    }

    //反射之后，对于Person的操作
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //创建对象
        Constructor cons = clazz.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("tom",12);
        Person p = (Person)obj;
        System.out.println(p);
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);


        System.out.println("------------------------------------");

        //反射调用私有结构，构造器，属性方法
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person)cons1.newInstance("Jerry");
        System.out.println(p1);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Hanmeimei");
        System.out.println(p1);

        Method shownation = clazz.getDeclaredMethod("showNation", String.class);
        shownation.setAccessible(true);
        String nation = (String) shownation.invoke(p1,"China");
        System.out.println(nation);
    }

    /*
    *1.类的加载过程：
    * 程序经过javac.exe命令后，会生成一个或多个字节码文件（.class结果）。
    * 接着使用java.exe命名对某个字节码文件进行解释执行。相当于将某个字节码文件加载到内存中。
    * 此过程就称为类的加载。加载到内存中的类就称为运行时类，此运行时类，就作为Class的一个实例。
    * */

    //获取Class的实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        //1.调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //2.通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        //3.调用Class的静态方法：forName(String classpath)
        Class clazz3 = Class.forName("edu.hust.se.Person");
        System.out.println(clazz3);//class edu.hust.se.Person
        //4.使用类加载器ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("edu.hust.se.Person");
        System.out.println(clazz4);
    }

    /*哪些类型有class对象
    * 1.class:外部类，成员（成员内部类，静态内部类），局部内部类，匿名内部类
    * 2，interface；接口
    * 3，[]数组
    * 4，enum:枚举
    * 5.annotation：注解@interface
    * 6.基本数据类型：int、char
    * 7.void
    * */


    /**
     * classloader 读取properties文件
     */
    @Test
    public void test4() throws Exception {
        Properties pros = new Properties();
        //此时的文件默认在当前的module下
        //读取配置文件方式1：
//        FileInputStream fis = new FileInputStream("jdbc.properties");
        ////解决方法：带上路径
        FileInputStream fis = new FileInputStream("src\\jdbc1.properties");
         pros.load(fis);


        //方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下(建议此种方式，部署web项目，项目下的配置文件不会放到classpath下)
        //ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        //InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        //pros.load(is);
        String user = pros.getProperty("user");
        String pwd = pros.getProperty("password");
        System.out.println("user="+user+",password="+pwd);


    }
}
