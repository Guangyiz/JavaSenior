package edu.wit.cs;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk8 之前日期和时间的测试
 */
public class DateTimeTest {
    @Test
    //system
    public void test() {
        long time = System.currentTimeMillis();//返回当前时间到1970.1.1.0:0:0以毫秒为单位的时间差，称为时间戳
        System.out.println(time);
    }


    @Test
    //java.util.Date
    //java.sql.Date对应数据库的日期类型的变量,注意：***sql.date类是util.date的子类***
    public void test2() {
        Date date1 = new Date();//util下的Date类
        System.out.println(date1.toString());//toString()显示当前的年月日周时分秒：Sun Apr 21 20:59:53 CST 2019
        System.out.println(date1.getTime());//当前时间对象的时间戳

        java.sql.Date date2 = new java.sql.Date(1555851889711L);
        System.out.println(date2);//2019-04-21
    }

    //util.date如何转为sql.date
    @Test
    public void test3() {
        Date date = new Date();
        System.out.println(date);
        java.sql.Date date1 = new java.sql.Date(date.getTime());//利用getTime()方法
        System.out.println(date1);
    }

    //SimpleDateFormat对日期Date类的格式化和解析
    @Test
    public void test4() throws ParseException {
        //实例化，默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        Date date = new Date();
        System.out.println(date);

        String date1 = sdf.format(date);
        System.out.println(date1);//19-4-21 下午9:20

        //字符串-》日期
        String str = "2019-04-21 上午10:10";
        Date date2 = sdf.parse(str);
        System.out.println(date2);

        //一般需要使用带参构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sdf1.format(new Date());
        System.out.println(format);

        Date date3 = sdf1.parse(format);
        System.out.println(date3);
    }

    //Calendar日历类的使用
    @Test
    public void test5(){
         //实例化
        //1.创建其子类(GregorianCalendar)的对象
        //2.调用其静态方法
        Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar.getClass());//class java.util.GregorianCalendar

        //常用方法
        //get（）
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);//当前月的第几天

        //set（）
        calendar.set(Calendar.DAY_OF_MONTH,22);//设置
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add（）
        calendar.add(Calendar.DAY_OF_MONTH,3);//当前时间增加几天
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        calendar.add(Calendar.DAY_OF_MONTH,-3);//当前时间减少几天
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime（）
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime（）:Date--->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.toString());


    }}
