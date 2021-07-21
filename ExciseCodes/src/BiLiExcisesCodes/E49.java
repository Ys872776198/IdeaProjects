package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/16
 * @Description: 利用创建线程的第二种方法完成作业:抢火车票
 * @Version: 1.0
 */
public class E49 implements Runnable {
    int ticket = 10;             //因为线程都共享一个子线程，所以不用static修饰,如果创建三个子线程那么就要用static修饰
    @Override
    public void run() {
        for(int i = 1; 1 < 101; i++){
            if(ticket > 0){
                System.out.println(("我在" + Thread.currentThread().getName() + "平台上抢到了第" + ticket-- + "张票！！！"));
            }
        }


    }
}

class E49_Main{
    public static void main(String[] args) {
//        作业：作业:3个工作平台,每个平台100人,抢10张票
//        创建三个线程
        E49 e1 = new E49();             //此处可以共享，也可以独立出来
//        E49 e2 = new E49();
//        E49 e3 = new E49();

        Thread t1 = new Thread(e1, "第一号");
        t1.start();

        Thread t2 = new Thread(e1, "第二号");
        t2.start();

        Thread t3 = new Thread(e1, "第三号");
        t3.start();

    }
}
