package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/14
 * @Description: 线程(创建线程的三种方法：1、继承Thread类)
 * @Version: 1.0
 */

//继承Thread类才能争抢CPU资源
//继承Thread类后必须重写Run方法
public class E46 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
//            获取线程名称，调用父类的getName方法(This.getName也可以)
            System.out.println((super.getName() + "------------------" + i));
        }
    }

    public E46(String name){
        super(name);                //此处是利用父类的构造器，而不是Thread.currentThread().setName(name)方法
                                    //因此在创建线程的第二个方法当中，不能在构造器中调用currentThread()方法来设置线程名称
    }

    public E46(){

    }
}


class E46_Main{
    public static void main(String[] args) {
//        设置主线程的名称调用currentThread()方法，这是个静态方法
        Thread.currentThread().setName("主线程");

//        创建线程对象，和主线程争抢资源
        E46 e1 = new E46();
//        子线程设置线程名称之间调用Thread里面的setName
        e1.setName("子线程");
//        e1.run();                       //线程中的Run方法不能直接调用，否则系统会将run方法看作一个普通方法来进行处理，因此不会出现争抢资源的现象
                                          //想要线程起作用就必须启动线程，调用Start方法
        e1.start();                       //start方法是Thread类中的方法， 同时要先启动子线程，在运行主线程的方法

        for(int i = 0; i < 10; i++){
            System.out.println((Thread.currentThread().getName() + "--------------------" + i));
        }
    }
}