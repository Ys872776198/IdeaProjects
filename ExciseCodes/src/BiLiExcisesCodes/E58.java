package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/20
 * @Description: 线程（线程通信）（续E55）
 * @Version: 1.0
 */
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
 * 总结：Java对象中，有两种池
 * 锁池-----------------synchronized
 * 等待池---------------wait(),notify(),notifyAll()方法（wait(),notify(),notifyAll()需要配合synchronized才有效）
 * 如果一个线程调用了某个对象的wait方法，那么该对象进入到该对象的等待池当中（并且已经将锁释放）
 * 如果未来的某一时刻，另外一个线程调用了相同对象的notify或者notifyAll方法
 * 那么该等待池中的线程就会被唤起然后进入到对象的锁池里面去获取该对象的锁
 * 如果获得锁成功，那么该线线程就会沿着wait方法之后的路径继续执行。注意是wait方法之后
 * 注意1：wait方法和notify或者notifyAll方法必须在同步方法或者同步代码块中才能生效（因为在同步的基础上进行线程的通信才是有效的）
 * 注意2：sleep和wait的区别：调用sleep后进入阻塞状态，但是不释放锁。调用wait方法后进入阻塞状态，但是释放了锁。
 *
 */

//产品
class CommodityThread4{
    private String brand;           //品牌
    private String name;            //产品名
    private boolean flag = false;           //用于判断商品是否存在，true代表存在，false代表不存在，默认为不存在

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

    public CommodityThread4() {
    }

    public CommodityThread4(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }
}

//生产者
class ProducerThread4 extends Thread{
    private CommodityThread4 ct;             //产品类

    public ProducerThread4(CommodityThread4 ct){
        this.ct = ct;
    }

    public ProducerThread4() {

    }

    @Override
    public void run() {
        for(int i = 1; i < 11; i++){
            synchronized(ct){
                if(ct.getFlag() == true){
                    try {
                        wait();                 //线程进入等待池，并且通知生产者生产
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
//                     do nothing
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

                notify();           //线程进入等待池，并且通知消费者消费
            }
        }
    }
}

//消费者
class ConsumerThread4 extends Thread{
    private CommodityThread4 ct;

    public ConsumerThread4(CommodityThread4 ct) {
        this.ct = ct;
    }
    public ConsumerThread4() {
    }

    @Override
    public void run() {
        for(int i = 1; i < 11; i++){
            synchronized (ct){
                if(ct.getFlag() == false){
                    try {
                        wait();                 //线程进入等待池
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
//                    do nothing
                }

                System.out.println("我消费了" + ct.getBrand() + "的" + ct.getName());

                ct.setFlag(false);        //生产结束，修改标志位

                notify();           //线程进入等待池，并且通知生产者生产
            }
        }
    }
}


public class E58 {
    public static void main(String[] args) {
        CommodityThread4 ct = new CommodityThread4();       //创建一个产品对象
        ProducerThread4 pt = new ProducerThread4(ct);       //创建生产者线程
        pt.start();
        ConsumerThread4 cst = new ConsumerThread4(ct);      //创建消费者线程
        cst.start();

    }
}
