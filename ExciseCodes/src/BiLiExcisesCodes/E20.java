package BiLiExcisesCodes;

import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/5/10
 * @Description: 异常引入
 * @Version: 1.0
 */
public class E20 {

    public static void main(String[] args) throws Exception {
//        while (true)
//        {
//            try {
//                Scanner sc = new Scanner(System.in);
//                System.out.println("请录入第一个数据：");
//                int a = sc.nextInt();
//                System.out.println("请录入第二个数据：");
//                int b = sc.nextInt();
//
//                System.out.println("商：" + (a / b));
//            }catch (Exception ex){
////                对异常的处理方式：
////                1、什么都不做
//
////                2、显示提示信息
////                System.out.println("数据错误！");
//
////                3、打印异常信息
////                (1)调用tostrin方法，显示异常的类名（全限定路径）
////                System.out.println(ex);
////                System.out.println(ex.toString());
//
////                (2)显示异常描述信息对应的字符串，如果没有就显示Null
////                System.out.println(ex.getMessage());
//
////                (3)显示异常的堆栈信息：将异常信息捕获以后，在控制台将异常的效果给我们展示出来，方便查看异常（不会打断catch后续代码运行）
////                ex.printStackTrace();
//
//
////                4、抛出异常(会打断后续程序的运行)
////                throw ex;
//            }
//
//            System.out.println("-----欢迎使用计算器！-----");
//
//        }

//        理解throw和throws的区别
//        制造一个除数为0时的异常
//        当被调用的方法有异常抛出时，调用者要么解决，要么在抛出（3、抛出异常，将异常抛给调用者）
//        1、自己解决
//        try {
//            divide();
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//        2、接着抛出
        divide();


    }

    public static void divide() throws Exception {

                Scanner sc = new Scanner(System.in);
                System.out.println("请录入第一个数据：");
                int a = sc.nextInt();
                System.out.println("请录入第二个数据：");
                int b = sc.nextInt();

               if(b == 0){
//                   1、制造运行的异常
//                   throw new RuntimeException();

//                   2、制造检查异常
//                   try{
//                       throw new Exception();
//                   }catch(Exception exception){
//                       exception.printStackTrace();
//                   }

//                   3、抛出异常，将异常抛给调用者
                   throw new Exception();

               }else {
                   System.out.println("商：" + (a / b));
               }


    }


}
