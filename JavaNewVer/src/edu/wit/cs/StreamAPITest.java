package edu.wit.cs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 对集合数据进行复杂的查询，过滤和映射。
 * collection是一种静态的内存数据结构，而streamAPI是面向计算的，与cpu打交道的
 * 使用3步：
 * 1.实例化
 * 2.中间操作链（过滤，映射。。。(延迟执行)）
 * 3.终止操作（调用终止操作时才会执行）
 */
public class StreamAPITest {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );
    @Test
    public void test() {
        //创建Stream方式一：通过集合

        List<String> list = new ArrayList<>();

        //返回一个顺序流
        Stream<String> stream = list.stream();

        //返回一个并行流
        Stream<String> parallelStream = list.parallelStream();


        //方式二通过数组,Arrays的Stream方法
        int[] arr = new int[]{1,2,3,4,5};
        IntStream intStream = Arrays.stream(arr);

        //方式三通过Stream的of方法
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);

        //方式四创建无限流
        //迭代：
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);

        //生成：
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }


    @Test
    public void test1() {
        //映射
        //map接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa","bb","cc");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        //flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，并连接成一个流

        Stream<Stream<Character>> stream2 = list.stream()
                .map(StreamAPITest::filterCharacter);

        stream2.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("---------------------------------------------");

        Stream<Character> stream3 = list.stream()
                .flatMap(StreamAPITest::filterCharacter);

        stream3.forEach(System.out::println);
    }


    @Test
    public void test2(){
        //sorted -自然排序
        List<Integer> list = Arrays.asList(12,43,65,34,87,-10,7);
        list.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)-定制排序
    }

    @Test
    public void test3(){
        //1.筛选与切片
        //filter,从流中排除某些数据
        List list = Collections.EMPTY_LIST;
        list.add(1);

    }


    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }

}
