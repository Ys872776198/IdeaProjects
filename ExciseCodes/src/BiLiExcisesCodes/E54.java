package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/19
 * @Description: 线程（lock锁）
 * @Version: 1.0
 */

import com.sun.scenario.effect.LockableResource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁是jdk1.5之后引入的
 * 与采用synchronized相比，lock可以提供多种锁方案，更灵活
 *
 * synchronized是Java中的关键字，这个关键字的识别是靠JVM来识别完成的，是虚拟机级别的
 * 但是lock锁是APl级别的，提供了相应的接口和对应的实现类，这个方法更灵活，表现出来的性能优于之前的方法
 *
 * lock和synchronized的区别
 * 1、lock是显式锁（需要手动开启和关闭锁，别忘记关锁），synchronized是隐式锁
 * 2、lock只有代码块锁，synchronized有代码块锁和方法锁
 * 3、使用lock锁，JVM将花费较少的时间来调度线程，性能更好，并且具有更好的扩展性（提供更多的子类）
 *
 * 优先使用顺序
 * lock ---- 同步代码块（已经进入方法体，分配了相应的资源） ---- 同步方法（在方法体之外）
 */



//买车票（继承Thread类）
class BuyTicketThread3 extends Thread {
    static int ticket = 10;

//    创建一个Lock对象（Lock是接口，不能直接创建对象，多态）
    static Lock lock = new ReentrantLock();                  //具体实现类查API（此处的不是一个对象，是三个，导致三个对象的锁不一致，出现错误，因此需要加上static修饰）

    @Override
    public void run() {
        for(int i = 1; 1 < 101; i++){
//            打开锁
            lock.lock();
//            万一锁内的代码出现，那么这个锁可能就不会关闭了，因此用try-catch-finally来解决这个问题
            try{
                Thread.sleep(100);           //增强效果
                if(ticket > 0){
                    System.out.println(("我在" + this.getName() + "平台上抢到了第" + ticket-- + "张票！！！"));
                }
            }catch(Exception exception){
                exception.printStackTrace();
            }finally{
//            关闭锁
                lock.unlock();
            }
        }
    }
}

//买车票（实现Runnable接口）
class BuyTicketRunnable3 implements Runnable {
    int ticket = 10;                //此处共享同一个对象，不用加static修饰

//    创建一个Lock对象（Lock是接口，不能直接创建对象，多态）
    Lock lock = new ReentrantLock();                  //具体实现类查API

    @Override
    public void run() {
        for(int i = 1; 1 < 101; i++){
//            打开锁
            lock.lock();
//            万一锁内的代码出现，那么这个锁可能就不会关闭了，因此用try-catch-finally来解决这个问题
            try{
                Thread.sleep(100);           //增强效果
                if(ticket > 0){
                    System.out.println(("我在" + Thread.currentThread().getName() + "平台上抢到了第" + ticket-- + "张票！！！"));
                }
            }catch(Exception exception){
                exception.printStackTrace();
            }finally{
//            关闭锁
                lock.unlock();
            }
        }
    }
}

public class E54 {
    public static void main(String[] args) {
//        买车票（继承Thread类）
        BuyTicketThread3 btt1 = new BuyTicketThread3();
        btt1.setName("thread子线程1");
        btt1.start();
        BuyTicketThread3 btt2 = new BuyTicketThread3();
        btt2.setName("thread子线程2");
        btt2.start();
        BuyTicketThread3 btt3 = new BuyTicketThread3();
        btt3.setName("thread子线程3");
        btt3.start();

//        买车票（实现Runnable接口）
//        BuyTicketRunnable3 btr = new BuyTicketRunnable3();
//        Thread t1 = new Thread(btr, "Runnable1");
//        t1.start();
//        Thread t2 = new Thread(btr, "Runnable2");
//        t2.start();
//        Thread t3 = new Thread(btr, "Runnable3");
//        t3.start();
    }
}
