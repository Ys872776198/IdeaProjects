package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/16
 * @Description: 利用创建线程的第一种方法完成作业:抢火车票(多次运行，出现错误，健壮性差，后续解决)
 * @Version: 1.0
 */
public class E47 extends Thread{
//    因为是三个平台共抢这10张票，所以要加static修饰
    static int piao = 10;

    @Override
    public void run() {
        for(int i = 1; i < 101; i++){
            if(piao > 0){
                System.out.println(("我在" + this.getName() + "平台上抢到了第" + piao-- + "张票！！！"));
            }

        }
    }
}

class E47_Mian{
    public static void main(String[] args) {
//        作业:3个工作平台,每个平台100人,抢10张票
//        1、创建3个线程对象
        E47 e1 = new E47();
        e1.setName("第一号");      //设置线程名称

        E47 e2 = new E47();
        e2.setName("第二号");      //设置线程名称

        E47 e3 = new E47();
        e3.setName("第三号");      //设置线程名称

//        启动线程
        e1.start();
        e2.start();
        e3.start();

    }
}