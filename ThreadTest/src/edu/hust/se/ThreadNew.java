package edu.hust.se;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现callable接口
 */
class NumThread implements Callable{
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 0;i<=100;i++){
            if(i%2 == 0){
                //System.out.println(i);
                sum += i;
                throw new RuntimeException();
            }
        }
        return sum;

    }
}
public class ThreadNew {
    public static void main(String[] args) {
        Callable numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);//FutureTasks是实现Future的唯一类，它同时实现了Runnable接口。

        new Thread(futureTask).start();
        try {
            //get（）返回值即为FutureTask构造器参数Callable实现类重写的call（）的返回值，但get方法并没有启动线程
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            System.out.println("--------------");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("+++++");
            e.printStackTrace();
        }
        System.out.println(".........");
    }
}
