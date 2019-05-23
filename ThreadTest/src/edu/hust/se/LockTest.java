package edu.hust.se;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式二：Lock锁
 * synchronized自动的启动和释放同步监视器
 * lock需要手动的启动同步和释放
 */

class Ticket5 implements Runnable{
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();//共用一把锁
    @Override
    public void run() {

        while (true){
            try{
                lock.lock();
                if(ticket > 0){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }//错票-1
                    System.out.println(Thread.currentThread().getName()+":"+ticket);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } //重票
                    ticket--;
                }else {
                    break;
                }

            }finally {
                lock.unlock();
            }

        }
    }
}


public class LockTest {
    public static void main(String[] args) {
        Runnable r = new Ticket5();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
