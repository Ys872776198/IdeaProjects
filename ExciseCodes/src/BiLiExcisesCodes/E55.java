package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/20
 * @Description: 线程（线程通信）（接E58）
 * @Version: 1.0
 */

/**
 * (1)在不加同步监视器的情况下，出现的结果乱的，为了保证出现的结果是有序的，即先出现生产的的商品是一一对应的，不会出现品牌和产品错位
 *      1、使用同步代码块解决(同步监视器不能使用This，应为此处的对象不同，导致生产者和消费者使用的锁不一致，因此此处可以使用商品作为同步监视器)
 *                       (这次的锁是放在消费者和生产者里面，所以同步监视器不能使用this，如果同步监视器在商品里面就可以使用this)
 *                       (运行的结果是生产多个，消费多个，这是正常现象，因为还没田间线程通信)
 */

//产品
class CommodityThread{
    private String brand;           //品牌
    private String name;            //产品名

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

    public CommodityThread() {
    }

    public CommodityThread(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }
}

//生产者
class ProducerThread extends Thread{
    private CommodityThread ct;             //产品类

    public ProducerThread(CommodityThread ct){
        this.ct = ct;
    }

    public ProducerThread() {

    }

    @Override
    public void run() {
        for(int i = 1; i < 11; i++){
            synchronized(ct){
                if((i % 2) == 0){
                    ct.setBrand("费列罗");
                    try {
                        Thread.sleep(100);              //增强效果
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ct.setName("巧克力");

                }else {
                    ct.setBrand("哈尔滨");
                    try {
                        Thread.sleep(100);              //增强效果
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ct.setName("啤酒");
                }
                System.out.println("我生产了" + ct.getBrand() + "的" + ct.getName());
            }
        }
    }
}

//消费者
class ConsumerThread extends Thread{
    private CommodityThread ct;

    public ConsumerThread(CommodityThread ct) {
        this.ct = ct;
    }
    public ConsumerThread() {
    }

    @Override
    public void run() {
        for(int i = 1; i < 11; i++){
            synchronized (ct){
                System.out.println("我消费了" + ct.getBrand() + "的" + ct.getName());
            }

        }
    }
}


public class E55 {
    public static void main(String[] args) {
        CommodityThread ct = new CommodityThread();       //创建一个产品对象
        ProducerThread pt = new ProducerThread(ct);       //创建生产者线程
        pt.start();
        ConsumerThread cst = new ConsumerThread(ct);      //创建消费者线程
        cst.start();

    }
}
