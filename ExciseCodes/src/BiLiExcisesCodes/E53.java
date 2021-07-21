package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/19
 * @Description: 线程（同步方法）
 * @Version: 1.0
 */

//买车票（继承Thread类）
class BuyTicketThread2 extends Thread {
    static int ticket = 10;
    @Override
    public void run() {
        for(int i = 1; 1 < 101; i++){
            try {
                Thread.sleep(10);           //增强实验效果
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                buyticket();
            }
        }
    }

//        利用同步方法解决问题，锁住关键位置即可，锁多了会降低效率
    public static synchronized void  buyticket(){                  //因为使用该类的对象有多个，因此不能直接用synchronized修饰，要在加上一个static修饰
                                                                   //static修饰固定了方法的地址，static synchronized = synchronized (BuyTicketThread.class)
        if(ticket > 0){
            System.out.println(("我在" + Thread.currentThread().getName() + "平台上抢到了第" + ticket-- + "张票！！！"));
        }
    }
}


//买车票（实现Runnable接口）
class BuyTicketRunnable2 implements Runnable {
    int ticket = 10;                //此处共享同一个对象，不用加static修饰
    @Override
    public void run() {
        for(int i = 1; 1 < 101; i++){
            try {
                Thread.sleep(10);           //增强实验效果
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                buyticket();
            }
        }
    }

//        利用同步方法解决问题，锁住关键位置即可，锁多了会降低效率
    public synchronized void  buyticket(){                  //因为使用该类的只有一个对象，因此synchronized = synchronized (this),锁住的是this
        if(ticket > 0){
            System.out.println(("我在" + Thread.currentThread().getName() + "平台上抢到了第" + ticket-- + "张票！！！"));
        }
    }
}



public class E53 {
    public static void main(String[] args) {
//        买车票（继承Thread类）
        BuyTicketThread2 btt1 = new BuyTicketThread2();
        btt1.setName("thread子线程1");
        btt1.start();
        BuyTicketThread2 btt2 = new BuyTicketThread2();
        btt2.setName("thread子线程2");
        btt2.start();
        BuyTicketThread2 btt3 = new BuyTicketThread2();
        btt3.setName("thread子线程3");
        btt3.start();

//        买车票（实现Runnable接口）
//        BuyTicketRunnable2 btr = new BuyTicketRunnable2();
//        Thread t1 = new Thread(btr, "Runnable1");
//        t1.start();
//        Thread t2 = new Thread(btr, "Runnable2");
//        t2.start();
//        Thread t3 = new Thread(btr, "Runnable3");
//        t3.start();
        /**
         * 总结
         * 总结1：
         * 多线程在争抢资源，就要实现线程同步（就要进行加锁，并且这个锁必须是共享的，必须是唯一的）
         * 锁一般是引用数据类型的
         * 目的：解决线程安全问题
         *
         * 总结2：
         * (1)不要将run()方法定义为同步方法
         * (2)非静态同步方法的同步监视器是this
         * 静态同步方法的同步监视器是 类名.class 字节码信息对象
         * (3)同步代码块的效率高于同步方法
         * 原因：同步方法是将线程挡在方法外部，而同步吧代码块锁将线程挡在代码块外部，但是在方法内部
         * (4)同步方法锁的是this，一旦锁住一个方法，就锁住了所有的同步方法；同步代码块只是锁住使用该同步监视器的代码块，而没有锁住使用其他同步监视器的代码块
         */

    }
}
