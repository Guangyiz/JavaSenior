package edu.wit.cs;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Jdk8DateTimeTest {
//LocalDate
    @Test
    public void test(){
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

//        2019-04-21
//        22:09:45.716
//        2019-04-21T22:09:45.716
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);

        LocalDateTime dateTime1 = LocalDateTime.of(2019, 10, 1, 10, 10, 10);
        System.out.println(dateTime1);
    }
}
