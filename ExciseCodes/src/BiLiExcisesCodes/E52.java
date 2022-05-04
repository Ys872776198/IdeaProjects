package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/18
 * @Description: 线程（同步代码块）
 * @Version: 1.0
 */
//买车票（继承Thread类）
class BuyTicketThread extends Thread {
    static int ticket = 10;
    @Override
    public void run() {
        for(int i = 1; 1 < 101; i++){
//            利用同步代码块解决问题，锁住关键位置即可，锁多了会降低效率
            synchronized (BuyTicketThread.class){           //这个锁就是BuyTicketThread.class（BuyTicketThread.class是字节码信息，唯一特殊）
                if(ticket > 0){
                    System.out.println(("我在" + this.getName() + "平台上抢到了第" + ticket-- + "张票！！！"));
                }
            }
        }
    }
}

//买车票（实现Runnable接口）
class BuyTicketRunnable implements Runnable {
    int ticket = 10;                //此处共享同一个对象，不用加static修饰
    @Override
    public void run() {
        for(int i = 1; 1 < 101; i++){
//            利用同步代码块解决问题，锁住关键位置即可,锁多了会降低效率
            synchronized (this){            //这个锁就是this
                if(ticket > 0){
                    System.out.println(("我在" + Thread.currentThread().getName() + "平台上抢到了第" + ticket-- + "张票！！！"));
                }
            }
        }
    }
}


public class E52 {
    public static void main(String[] args) {
//        买车票（继承Thread类）
//        BuyTicketThread btt1 = new BuyTicketThread();
//        btt1.setName("thread子线程1");
//        btt1.start();
//        BuyTicketThread btt2 = new BuyTicketThread();
//        btt2.setName("thread子线程2");
//        btt2.start();
//        BuyTicketThread btt3 = new BuyTicketThread();
//        btt3.setName("thread子线程3");
//        btt3.start();

//        买车票（实现Runnable接口）
        BuyTicketRunnable btr = new BuyTicketRunnable();
        Thread t1 = new Thread(btr, "Runnable1");
        t1.start();
        Thread t2 = new Thread(btr, "Runnable2");
        t2.start();
        Thread t3 = new Thread(btr, "Runnable3");
        t3.start();

//        问题：无论是那种用那种方法来创建线程，完成买火车票的代码，都会出现线程未走完整个流程，就被其他线程抢夺资源的现象，导致结果出现问题
//        原因：多个线程，在抢夺资源的过程中，导致共享的资源出现问题，一个线程没有执行完，另一个线程就参与进来了，开始抢夺资源
//        解决方法：“上锁“，即加上同步监视器synchronized(”锁“),利用同步代码块，同步方法，或者lock锁

//        synchronized(”锁“):this代表当前这个对象，当共享一个类时，this就是一个唯一特殊的。
//        但是在继承继承Thread类中，这个this代表的对象不一致，即三个对象上了不是同一把锁，这样还是会出现线程安全问题。
//        锁的原则就是要唯一特殊的,无论是this还是BuyTicketThread.class都是唯一特殊的，即要上的是同一把锁。

        /**
         * 同步监视器总结
         * 总结1：认识同步监视器（锁）-------- synchornized(同步监视器)
         * (1)同步监视器必须是引用数据类型，不能是基本数据类型
         * (2)也可以创建一个专门的同步监视器，没有任何业务含义（若类被共享，可以不用static修饰。如没有共享可以用static修饰）
         * (3)一般使用共享的资源做同步监视器即可
         * (4)在同步代码块中不能改变同步监视器对象的引用（保证锁的地址不能被改变，可以使用final修饰）
         * (5)尽量不要使用String和包装类Integer做同步监视器
         * (6)建议使用final修饰同步监视器（保证监视器是一个不能被随意改变的值）（被final修饰的类，地址不能改变，但是里面的属性可以改变）
         *
         * 总结2：同步代码块的执行过程
         * (1)第一个线程来到同步代码块，发现同步监视器处于open状态，需要close，然后执行其中代码
         * (2)第一个线程执行中，发生线程切换（阻塞或者就绪状态），第一个线程失去CPU，但是同步监视器处于close状态
         * (3)第二个线程获取CPU，来到了同步代码块，发现同步监视器处于close状态，无法执行其中的代码，第二个线程进入阻塞状态
         * (4)第一个线程再次获取CPU，执行后续代码；同步代码块执行完毕，释放open
         * (5)第二个线程也再次获取CPU。来到同步代码块，发现代码块处于open状态，拿到锁并且上锁，由阻塞状态进入就绪状态，再次进入运行状态，重复第一个线程的处理状态（加锁）
         * 强调：同步代码块中能发生CPU的切换，但是后续被执行的线程无法执行同步代码块（因为同步代码块处于Close状态）
         *
         * 总结3：其他
         * (1)多个代码块使用同一个同步监视器，锁住一个代码块的同时，也锁住所有使用该锁的所有代码块，其他去线程无法访问其中任何一个代码块
         * (2)多个代码块使用同一个同步监视器，锁住一个代码块的同时，也锁住所有使用该锁的所有代码块，但是没有锁住使用其他同步监视器的代码块，其他线程有机会访问其他同步监视器的代码块
         */



    }

}