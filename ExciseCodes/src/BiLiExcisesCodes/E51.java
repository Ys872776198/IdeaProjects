package BiLiExcisesCodes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @Auther: YS
 * @Date: 2021/7/18
 * @Description: 线程常见的方法
 * @Version: 1.0
 */
public class E51 extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 50; i++){
//            获取线程名称，调用父类的getName方法(This.getName也可以)
            System.out.println((super.getName() + "------------------" + i));
        }
    }
}

class E51_Main{
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("主线程");
//        System.out.println(Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(1);
//        System.out.println(Thread.currentThread().getPriority());

        E51 t1 = new E51();
        E51 t2 = new E51();

        t1.setName("子线程");                  //先设置，在启动

//        线程常用方法
////            1、设置优先级setPriority()方法(优先度越高，代表被CPU调动的几率越大，并不代表一点有限调动)
////               优先级最高为10，最低为1，默认为5。先设置在启动
////               获取优先级getPriority()方法
//        System.out.println(t1.getPriority());
//        t1.setPriority(10);
//        System.out.println(t1.getPriority());
//        t1.start();
//        for(int i = 0; i < 10; i++){
//            System.out.println((Thread.currentThread().getName() + "--------------------" + i));
//        }

//              2、设置优先执行join()方法(当线程调用join方法时，这个线程会被优先执行，这个线程执行完毕后，其他线程才开始执行)
//                 必须先start，在join
//        for(int i = 0; i < 10; i++){
//            System.out.println((Thread.currentThread().getName() + "--------------------" + i));
//            if(i == 2){
//                t1.start();
//                t1.join();          //不调用join()方法时，系统会先执行玩主线程，再走子线程。
//                                    //调用时，主线程会进入阻塞状态，子线程结束，主线程才会进入运行状态。
//            }
//        }

//                3、设置阻塞事件,Sleep()方法(单位为毫秒，1000ms = 1s),这是个静态方法
//        DateFormat df = new SimpleDateFormat("HH:mm:ss");
//        while(true){        //计时器，1s显示一次
//            System.out.println(df.format(new Date()));
//            Thread.sleep(1000);
//        }

//                4、设置伴随线程setDaemon()方法，先设置，再启动
//        t1.setDaemon(true);                 //表示子线程伴随主线程，当主线程停止时，子线程也会停止(不一定是立刻停止，可能会晚一点，但是会停下来)
//        t1.start();
//        for(int i = 0; i < 10; i++){
//            System.out.println((Thread.currentThread().getName() + "--------------------" + i));
//        }

//                5、设置线程结束stop方法(已废止)
//        for(int i = 0; i < 10; i++){
//            System.out.println((Thread.currentThread().getName() + "--------------------" + i));
//            if(i == 5){
//                Thread.currentThread().stop();
//            }
//        }
        
    }
}
