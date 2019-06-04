package edu.wit.cs;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * stream终止操作
 */
public class StreamTest2 {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //1.匹配与查找
    @Test
    public void test(){
        boolean allMatch = emps.stream().allMatch(employee -> employee.getAge() > 18);
        System.out.println(allMatch);
    }

    //2.收集
    @Test
    public void test2(){
        List<Employee> collect = emps.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    //归约reduce
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        System.out.println(reduce);
    }
}
