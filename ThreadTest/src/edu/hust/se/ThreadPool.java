package edu.hust.se;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池创建线程
 */

class NumThread1 implements Runnable{
    @Override
    public void run() {
        int sum = 0;
        for(int i = 0;i<=100;i++){
            if(i%2 == 0){
                System.out.println(i);
                sum += i;
            }
        }

    }
}
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);//executors:工具类、线程池的工厂类，用于创建并返回不同类型的线程池
        executorService.execute(new NumThread1());//executorservice真正的线程池接口。常见子类ThreadPoolExecutor
        executorService.shutdown();

    }
}
