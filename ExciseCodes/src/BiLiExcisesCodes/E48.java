package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/16
 * @Description: 线程(创建线程的三种方法：2、实现Runnable接口)
 * @Version: 1.0
 */
public class E48 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
//            获取线程名称，这是个接口可以利用Thread.currentThread()
            System.out.println((Thread.currentThread().getName() + "------------------" + i));
        }
    }

}

class E48_Main{
    public static void main(String[] args) {
//        创建子线程
        E48 e1 = new E48();
//        Thread t1 = new Thread(e1);             //将自定义线程和Thread产生关联
        Thread t1 = new Thread(e1, "子线程");             //将自定义线程和Thread产生关联
//        启动线程
        t1.start();

        Thread.currentThread().setName("主线程");
        for(int i = 0; i < 10; i++){
            System.out.println((Thread.currentThread().getName() + "--------------------" + i));
        }
    }
}