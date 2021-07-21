package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/20
 * @Description: 线程（线程通信）（续E56）
 * @Version: 1.0
 */
/**
 * (1)在不加同步监视器的情况下，出现的结果乱的，为了保证出现的结果是有序的，即先出现生产的的商品是一一对应的，不会出现品牌和产品错位
 *      2、使用同步方法解决（将方法添加在商品类中）
 *                      (此处就可以使用this作为同步监视器)
 *                      (运行的结果是生产多个，消费多个，这是正常现象，因为还没田间线程通信)
 * (2)加入线程通信，将运行的结果改为先生产，在消费，出现的结果变为优先的交替进行的
 *
 * 总结：Java对象中，有两种池
 * 锁池-----------------synchronized
 * 等待池---------------wait(),notify(),notifyAll()方法
 * 如果一个线程调用了某个对象的wait方法，那么该对象进入到该对象的等待池当中（并且已经将锁释放）
 * 如果未来的某一时刻，另外一个线程调用了相同对象的notify或者notifyAll方法
 * 那么该等待池中的线程就会被唤起然后进入到对象的锁池里面去获取该对象的锁
 * 如果获得锁成功，那么该线线程就会沿着wait方法之后的路径继续执行。注意是wait方法之后
 */

//产品
class CommodityThread3{
    private String brand;           //品牌
    private String name;            //产品名
    private boolean flag = false;           //用于判断商品是否存在，true代表存在，false代表不存在，默认为不存在

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

    public CommodityThread3() {
    }

    public CommodityThread3(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public synchronized void Producer(String brand, String name){
        if(flag == true){
            try {
                wait();                 //线程进入等待池，并且通知生产者生产
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
//            do nothing
        }

        this.setBrand(brand);
        this.setName(name);
        System.out.println("我生产了" + this.getBrand() + "的" + this.getName());

        flag = true;        //生产结束，修改标志位

        notify();           //线程进入等待池，并且通知消费者消费
    }

    public synchronized void Consumer(){
        if(flag == false){
            try {
                wait();                 //线程进入等待池
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
//            do nothing
        }
        System.out.println("我消费了" + this.getBrand() + "的" + this.getName());

        flag = false;       //消费结束，修改标志位

        notify();           //线程进入等待池，并且通知生产者生产
    }
}

//生产者
class ProducerThread3 extends Thread{
    private CommodityThread3 ct;             //产品类

    public ProducerThread3(CommodityThread3 ct){
        this.ct = ct;
    }

    public ProducerThread3() {
        System.out.println("我消费了" + ct.getBrand() + "的" + ct.getName());
    }

    @Override
    public void run() {
        for(int i = 1; i < 11; i++){
            if((i % 2) == 0){
                ct.Producer("费列罗", "巧克力");
            }else {
                ct.Producer("哈尔滨", "啤酒");
            }
        }
    }
}

//消费者
class ConsumerThread3 extends Thread{
    private CommodityThread3 ct;

    public ConsumerThread3(CommodityThread3 ct) {
        this.ct = ct;
    }
    public ConsumerThread3() {
    }

    @Override
    public void run() {
        for(int i = 1; i < 11; i++){
            ct.Consumer();
        }
    }
}


public class E57 {
    public static void main(String[] args) {
        CommodityThread3 ct = new CommodityThread3();       //创建一个产品对象
        ProducerThread3 pt = new ProducerThread3(ct);       //创建生产者线程
        pt.start();
        ConsumerThread3 cst = new ConsumerThread3(ct);      //创建消费者线程
        cst.start();
    }

}
