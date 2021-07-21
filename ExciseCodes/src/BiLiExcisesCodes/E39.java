package BiLiExcisesCodes;

import java.io.*;

/**
 * @Auther: YS
 * @Date: 2021/7/6
 * @Description: IO流(访问文件:FileInputStream和FileOutputStream)
 * @Version: 1.0
 */

//throws
//public class E39 {
//    public static void main(String[] args) throws IOException {
////        功能：非文本文件复制
////        1、创建一个源文件对象和目标文件对象
////            源文件对象
//        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "电子签名.jpg");
////            目标文件对象
//        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "Copy_电子签名.jpg");
//
////        2、将源文件和输入流对象链接起来，将目标文件和输出流对象链接起来
////            源文件和输入流对象链接起来
//        FileInputStream fis = new FileInputStream(f1);
////            目标文件和输出流对象链接起来
//        FileOutputStream fos = new FileOutputStream(f2);                  //不加参数,默认false
////        FileOutputStream fos = new FileOutputStream(f2, false);     //参数False代表写入文件开始处(覆盖)
////        FileOutputStream fos = new FileOutputStream(f2, true);      //参数true代表数据写入文件末尾处(追加)
//        /*
//            细节1：文件是utf-8格式的，英文字符占一个字节，而中文字符占3个字节，使用字节流读取文本文件，会将中文打断成3个字节的数据，这样做意义不大
//
//            细节2：文本文件建议使用字符流，非文本文件按建议使用字节流
//
//            细节3：read读取一个字节，但是返回值是int类型而不是byte类型。因为byte类型的取值范围是-127~128，但是read读取到文件末尾返回值为-1，
//            此时无法区分，返回值是读取的字节还是读到文件末尾。因此read方法做了处理，返回值都是“正数”，用以区分读到文件末尾的返回值还是读取的字节。
//
//         */
//
////        3、完成读写操作
////            单个字节读写
////        int n = fis.read();
////        while(n != (-1)){
////            System.out.println(n);
////            fos.write(n);                   //写操作
////            n = fis.read();                 //读操作
////        }
//
////            利用缓冲数组来读写
//        byte[] bt = new byte[1024 * 8];
////        int n = fis.read(bt, 0, 1024 * 7);          //返回的是读取的有效长度
//        int n = fis.read(bt);                         //不带参数，代表偏移量默认为0，读取长度为数组的长度（功能与上行相同）
//
//        while(n != (-1)){
//            System.out.println(n);
//            fos.write(bt, 0 , n);                   //写操作，必须要设置入参
////            n = fis.read(bt, 0, 1024 * 7);            //读操作，需要设置读取长度
//            n = fis.read(bt);                           //不带参数，代表偏移量默认为0，读取长度为数组的长度（功能与上行相同）
//        }
//
////        4、关闭字节流
//        fos.close();
//        fis.close();
//    }
//}


//try-catch(为了更好展示效果,去掉了注释代码,完整版如上)(工作中常用)(详细注释参考E38)
public class E39 {
    public static void main(String[] args)  {
//        功能：非文本文件复制
//        1、创建一个源文件对象和目标文件对象
//            源文件对象
        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "电子签名.jpg");
//            目标文件对象
        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "Copy_电子签名.jpg");

//        2、将源文件和输入流对象链接起来，将目标文件和输出流对象链接起来
//            源文件和输入流对象链接起来
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
//            源文件和输入流对象链接起来
            fis = new FileInputStream(f1);
//            目标文件和输出流对象链接起来
            fos = new FileOutputStream(f2);                  //不加参数,默认false

//        3、完成读写操作
//            利用缓冲数组来读写
            byte[] bt = new byte[1024 * 8];
            int n = fis.read(bt);                         //不带参数，代表偏移量默认为0，读取长度为数组的长度（功能与上行相同）

            while(n != (-1)){
                System.out.println(n);
                fos.write(bt, 0 , n);                   //写操作，必须要设置入参
                n = fis.read(bt);                           //不带参数，代表偏移量默认为0，读取长度为数组的长度（功能与上行相同）
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//        4、关闭字节流
            try {
                if(fos != null){
                    fos.close();
                }else{
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fis != null){
                    fis.close();
                }else{
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}