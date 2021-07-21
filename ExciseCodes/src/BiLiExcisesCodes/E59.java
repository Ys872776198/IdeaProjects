package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/20
 * @Description: 线程（线程通信）（lock）
 * @Version: 1.0
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * (1)在不加同步监视器的情况下，出现的结果乱的，为了保证出现的结果是有序的，即先出现生产的的商品是一一对应的，不会出现品牌和产品错位
 *      1、使用同步代码块解决(同步监视器不能使用This，应为此处的对象不同，导致生产者和消费者使用的锁不一致，因此此处可以使用商品作为同步监视器)
 *                       (这次的锁是放在消费者和生产者里面，所以同步监视器不能使用this，如果同步监视器在商品里面就可以使用this)
 *                       (运行的结果是生产多个，消费多个，这是正常现象，因为还没田间线程通信)
 * (2)加入线程通信，将运行的结果改为先生产，在消费，出现的结果变为优先的交替进行的
 *                       (这里会出现“Exception in thread "Thread-0" Exception in thread "Thread-1" java.lang.IllegalMonitorStateException”)
 *                       (原因：生产者在调用wait方法后，锁释放，并且线程会进入生产者的等待池中，只有再次调用同对象中的notify方法才能唤起等待池中的线程。
 *                        但是，由于使用的是同一把锁，生产者在等待池时，锁已经释放，因此消费者也能进入消费者线程，同理消费者调用wait方法会进入到消费者的等待池，只有再次调用同对象中的notify方法才能唤起等待池中的线程。
 *                        由于进入的是不同的等待池，所以调用notify不能唤起另外一个等待池的线程。这也就是为什么同步方法可行，但是同步代码块不行的原因)
 *                        (解决方法：使用Condition，例如E59)
 *
 * 总结：
 * Condition是jdk1.5之后出来代替Object里面的wait和notify，Condition是接口，其中的await和signal方法实现线程间的协作更加高效和安全
 * 一个Condition包含一个等待队列，一个lock可以产生多个Condition，lock(同步器)拥有一个同步队列和多个等待队列
 * Condition的await和signal方法必须在lock保护内，即必须在Lock.lock和Lock.unlock之间才可以使用
 *
 */

//产品
class CommodityThread5{
    private String brand;           //品牌
    private String name;            //产品名
    private boolean flag = false;           //用于判断商品是否存在，true代表存在，false代表不存在，默认为不存在

    Lock lock = new ReentrantLock();            //创建一把锁
    Condition producer = lock.newCondition();   //创建生产者线程（Condition是接口，不能直接创建对象）
    Condition consumer = lock.newCondition();   //创建消费者线程（Condition是接口，不能直接创建对象）

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommodityThread5() {
    }

    public CommodityThread5(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }
}

//生产者
class ProducerThread5 extends Thread{
    private CommodityThread5 ct;             //产品类

    public ProducerThread5(CommodityThread5 ct){
        this.ct = ct;
    }

    public ProducerThread5() {

    }

    @Override
    public void run() {
        for(int i = 1; i < 11; i++){
            ct.lock.lock();             //开锁
            try{
                if(ct.getFlag() == true){
                    ct.producer.await();    //生产者阻塞，进入到生产者的队列当中
                }
                if((i % 2) == 0){
                    ct.setBrand("费列罗");
                    ct.setName("巧克力");
                }else {
                    ct.setBrand("哈尔滨");
                    ct.setName("啤酒");
                }
                System.out.println("我生产了" + ct.getBrand() + "的" + ct.getName());

                ct.setFlag(true);        //生产结束，修改标志位

                ct.consumer.signal();   //唤起消费者
            }catch(Exception exception){
                exception.printStackTrace();
            }finally {
                ct.lock.unlock();       //关锁
            }
        }
    }
}

//消费者
class ConsumerThread5 extends Thread{
    private CommodityThread5 ct;

    public ConsumerThread5(CommodityThread5 ct) {
        this.ct = ct;
    }
    public ConsumerThread5() {
    }

    @Override
    public void run() {
        for(int i = 1; i < 11; i++){
            ct.lock.lock();                 //开锁
            try{
                if(ct.getFlag() == false){
                    ct.consumer.await();    //消费者阻塞，进入到消费者的队列当中
                }
                System.out.println("我消费了" + ct.getBrand() + "的" + ct.getName());
                ct.setFlag(false);        //生产结束，修改标志位

                ct.producer.signal();     //唤起生产者
            }catch(Exception exception){
                exception.printStackTrace();
            } finally {
                ct.lock.unlock();           //关锁
            }
        }
    }
}


public class E59 {
    public static void main(String[] args) {
        CommodityThread5 ct = new CommodityThread5();       //创建一个产品对象
        ProducerThread5 pt = new ProducerThread5(ct);       //创建生产者线程
        pt.start();
        ConsumerThread5 cst = new ConsumerThread5(ct);      //创建消费者线程
        cst.start();

    }
}
