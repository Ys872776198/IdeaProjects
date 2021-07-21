package BiLiExcisesCodes;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: YS
 * @Date: 2021/7/16
 * @Description: 线程(创建线程的三种方法：3、实现callable接口)
 * @Version: 1.0
 */
public class E50 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        return  new Random().nextInt(10);        //返回一个10以内的整形数据
    }
}


class E50_Main{
    public static void main(String[] args) {
        E50 e = new E50();
        FutureTask<Integer> ft = new FutureTask<Integer>(e);           //通过FutureTask类将子线程和Thread链接起来(这也是第三种方法的确定，创建线程麻烦)
        Thread t = new Thread(ft,"子线程");
        t.start();
//        获取线程得到返回值(调用FutureTask类里面的get方法)
        try {
            Integer i = ft.get();
            System.out.println(t.getName()+ ":" + i);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (ExecutionException executionException) {
            executionException.printStackTrace();
        }


    }
}



