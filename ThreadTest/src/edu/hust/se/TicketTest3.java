package edu.hust.se;


// * 创建三个线程卖票，使用实现Runnable的方式。
// * 卖票过程中，出现重票和错票，--》线程安全
// * 原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来
// * 解决：加锁（类比上厕所的坑。。。），当一个线程在操作票的时候，其他不能参与进来，直到操作完成才能进来
// *一：同步代码块：synchronized（同步监视器）{
// *      //操作共享数据的代码
// *}
//  同步监视器，俗称：锁。任何一个类的对象，都可以充当锁,多个线程必须要共用同一把锁。
// * 二：同步方法：
//整个方法都是同步代码块
//

class Ticket3 implements Runnable{//实现Runnable的方式
    private int ticket = 100;
    @Override
    public void run() {

        while (true) {
            show();
        }

    }

    private synchronized void show(){//使用同步监视器this
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
                }
        }
}



public class TicketTest3 {
    public static void main(String[] args) {
        Runnable r = new Ticket3();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
