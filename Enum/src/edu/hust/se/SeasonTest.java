package edu.hust.se;

import org.junit.Test;

public class SeasonTest {

    @Test
    public void test(){
        Season season = Season.SPRING;
        System.out.println(season);
    }

    //enum父类的常用方法:toString(),values(),valueOf(String name)

    @Test
    public void test1(){
        Season[] values = Season.values();
        for (Season v: values){
            System.out.println(v);
            v.show();
        }
        System.out.println("-----------");
        Season winner = Season.valueOf("WINNER");
//        Season winner = Season.valueOf("WINNER1");//跑异常
        System.out.println(winner);
    }

}

interface info{
    void show();
}

//可实现接口
enum Season implements info{
    //多个对象之间用，隔开，最后一个用；结束,可以让枚举对象分别实现接口
    SPRING("春天","春乱花开"){
        @Override
        public void show() {
            System.out.println("this is spring");
        }
    },
    WINNER("冬天","冷"){
        @Override
        public void show() {
            System.out.println("this is winner");
        }
    };

    private final String name;
    private final String nameDesc;

    private Season(String name,String nameDesc){
        this.name = name;
        this.nameDesc = nameDesc;
    }

    public String getName() {
        return name;
    }

    public String getNameDesc() {
        return nameDesc;
    }

//    @Override
//    public String toString() {
//        return "Season{"+"name='"+name+"'"+",nameDesc='"+nameDesc+"'"+"'}";
//    }

}
