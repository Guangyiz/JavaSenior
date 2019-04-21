package edu.hust.se;

/**
 * 线程通信：交替打印1-00
 * wait()
 * notify唤醒被wait的一个线程，多个唤醒优先级最高的
 * notify唤醒被wait所有被wait的线程
 * 必须使用在同步代码块或同步方法中
 */
class Number implements Runnable {
    private  int number = 1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {//使用同步代码块
                notify();
                if(number <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    try {//当前线程进入阻塞状态，搭配notify使用
                        wait();//释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }

        }
    }
}


public class CommunicationTest {
    public static void main(String[] args) {
        Runnable r = new Number();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }


}
