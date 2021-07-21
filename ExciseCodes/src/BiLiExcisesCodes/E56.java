package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/20
 * @Description: 线程（线程通信）（接E57）
 * @Version: 1.0
 */
/**
 * (1)在不加同步监视器的情况下，出现的结果乱的，为了保证出现的结果是有序的，即先出现生产的的商品是一一对应的，不会出现品牌和产品错位
 *      2、使用同步方法解决（将方法添加在商品类中）
 *                      (此处就可以使用this作为同步监视器)
 *                      (运行的结果是生产多个，消费多个，这是正常现象，因为还没田间线程通信)
 */

//产品
class CommodityThread2{
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

    public CommodityThread2() {
    }

    public CommodityThread2(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public synchronized void Producer(String brand, String name){
        this.setBrand(brand);
        try {
            Thread.sleep(100);              //增强效果
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("我生产了" + this.getBrand() + "的" + this.getName());
    }

    public synchronized void Consumer(){
        System.out.println("我消费了" + this.getBrand() + "的" + this.getName());
    }
}

//生产者
class ProducerThread2 extends Thread{
    private CommodityThread2 ct;             //产品类

    public ProducerThread2(CommodityThread2 ct){
        this.ct = ct;
    }

    public ProducerThread2() {
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
class ConsumerThread2 extends Thread{
    private CommodityThread2 ct;

    public ConsumerThread2(CommodityThread2 ct) {
        this.ct = ct;
    }
    public ConsumerThread2() {
    }

    @Override
    public void run() {
        for(int i = 1; i < 11; i++){
            ct.Consumer();
        }
    }
}


public class E56 {
    public static void main(String[] args) {
        CommodityThread2 ct = new CommodityThread2();       //创建一个产品对象
        ProducerThread2 pt = new ProducerThread2(ct);       //创建生产者线程
        pt.start();
        ConsumerThread2 cst = new ConsumerThread2(ct);      //创建消费者线程
        cst.start();
    }

}
