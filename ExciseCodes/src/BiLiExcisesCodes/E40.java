package BiLiExcisesCodes;

import java.io.*;

/**
 * @Auther: YS
 * @Date: 2021/7/9
 * @Description: IO流(访问文件: BufferedInputStream和BufferedOutputStream(缓冲字节流，处理流))
 * @Version: 1.0
 */
//throws
//public class E40 {
//    public static void main(String[] args) throws IOException {
////        功能：利用缓冲字节流完成非文本文件的复制
////        1、创建源文件对象，目标文件对象
////            源文件对象
//        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "电子签名.jpg");
////            目标文件对象
//        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "Copy_电子签名.jpg");
//
////        2、将源文件和输入流对象链接起来，将目标文件和输出流对象链接起来
////            将源文件与字节输入流链接起来
//        FileInputStream fis = new FileInputStream(f1);
////            将字节输出流与目标文件链接起来
//        FileOutputStream fos = new FileOutputStream(f2);
//
////            将字节输入流与缓冲输入字节流链接起来
//        BufferedInputStream bis = new BufferedInputStream(fis);
////            将字节输出流与缓冲输出流链接起来
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
//
////        3、完成功能
////            单个字节
////        int n = bis.read();
////        while(n != (-1)){
////            bos.write(n);
////            n = bis.read();
////        }
//
////            缓冲数组
//        byte[] bt = new byte[1024];
////        int n = bis.read(bt, 0 , 1024);       //返回的是读取的有效长度
//        int n = bis.read(bt);                         //不带参数，代表偏移量默认为0，读取长度为数组的长度（功能与上行相同）
//        while (n != (-1)){
//            bos.write(bt, 0, n);                  //write方需要添加偏移量和读取的有效长度
//            n = bis.read(bt);
//        }
//
////        4、关闭流(当使用处理流时，关闭外层高级流就可以，依然遵循后开先关)
//        bos.close();
//        bis.close();
//    }
//}


//try-catch(为了更好展示效果,去掉了注释代码,完整版如上)(工作中常用)(详细注释参考E38)
public class E40 {
    public static void main(String[] args) {
//        功能：利用缓冲字节流完成非文本文件的复制
//        1、创建源文件对象，目标文件对象
//            源文件对象
        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "电子签名.jpg");
//            目标文件对象
        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "Copy_电子签名.jpg");

//        2、将源文件和输入流对象链接起来，将目标文件和输出流对象链接起来
//            将源文件与字节输入流链接起来
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(f1);
//            将字节输出流与目标文件链接起来
            fos = new FileOutputStream(f2);

//            将字节输入流与缓冲输入字节流链接起来
             bis = new BufferedInputStream(fis);
//            将字节输出流与缓冲输出流链接起来
            bos = new BufferedOutputStream(fos);

//        3、完成功能
//            缓冲数组
            byte[] bt = new byte[1024];
//        int n = bis.read(bt, 0 , 1024);       //返回的是读取的有效长度
            int n = bis.read(bt);                         //不带参数，代表偏移量默认为0，读取长度为数组的长度（功能与上行相同）
            while (n != (-1)){
                bos.write(bt, 0, n);                  //write方需要添加偏移量和读取的有效长度
                n = bis.read(bt);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
//        4、关闭流(当使用处理流时，关闭外层高级流就可以，依然遵循后开先关)
            try {
                if(bos != null){
                    bos.close();
                }else {
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
               if(bis != null){
                   bis.close();
               }else {
//                    do nothing
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}