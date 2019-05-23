package edu.hust.se;


// * 创建三个线程卖票，使用实现Runnable的方式。
// * 卖票过程中，出现重票和错票，--》线程安全
// * 原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来
// * 解决：加锁（类比上厕所的坑。。。），当一个线程在操作票的时候，其他不能参与进来，直到操作完成才能进来
// *一：同步代码块：synchronized（同步监视器）{
// *      //操作共享数据的代码
// *}
//  同步监视器，俗称：锁。任何一个类的对象，都可以充当锁,多个线程必须要共用同一把锁。
// * 二：同步方法

class Ticket implements Runnable{
    private int ticket = 100;
    private Object obj = new Object();//共用一把锁
    @Override
    public void run() {

        while (true){
            synchronized(this) {//当前对象//synchronized (obj){
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

            }

        }
    }
}

public class TicketTest {
    public static void main(String[] args) {
        Runnable r = new Ticket();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
