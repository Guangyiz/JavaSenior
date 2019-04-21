package edu.hust.se;

class Ticket2 extends Thread{//使用继承Thread的方式
    private static int ticket = 100;
    private static Object obj = new Object();//必须使用static保证共用一把锁
    @Override
    public void run() {

        while (true){
            //synchronized (this){ //对象不唯一
            synchronized (Ticket2.class){//使用类对象 //synchronized (obj){
                if(ticket > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }//增加错票概率-1
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

public class TicketTest2 {
    public static void main(String[] args) {
        Thread t1 = new Ticket2();
        Thread t2 = new Ticket2();
        Thread t3 = new Ticket2();
        t1.start();
        t2.start();
        t3.start();
    }
}
