package BiLiExcisesCodes;

import java.io.*;

/**
 * @Auther: YS
 * @Date: 2021/7/9
 * @Description: IO流(访问文件: InputStreamReader和OutputStreamWiter(字符转换流,处理流))
 * @Version: 1.0
 */
//throws
//public class E42 {
//    public static void main(String[] args) throws IOException {
////        功能:利用字节流复制文本文件
////        1、创建源文件对象和目标文件对象
////            创建源文件对象
//        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "1.txt");
////            创建目标文件对象
//        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "2.txt");
//
////        2、将源文件对象和输入流对象链接起来，目标文件和输出流链接起来
////        (在利用字符转换流时，输入或者输出都必须选择字符转换流对象，不能使用字符输入流接收或者输出文本内容，这点与原来设想有冲突)
//////            将源文件与字符输入流链接
////        FileReader fr = new FileReader(f1);
//////            将目标文件与字符输出流链接
////        FileWriter fw = new FileWriter(f2);
////            将源文件和字节输入流链接
//        FileInputStream fis = new FileInputStream(f1);
////            将目标文件与字节输出流链接
//        FileOutputStream fos = new FileOutputStream(f2);
////            将源文件与字符转换输入流链接
//        InputStreamReader isr = new InputStreamReader(fis);
////            将目标文件和字符转换输出流链接
//        OutputStreamWriter osw = new OutputStreamWriter(fos);
//
////        3、完成功能
////            单字节
////        int n = isr.read();
////        while (n != (-1)){
////            osw.write(n);
////            n = isr.read();
////        }
//
////            缓冲数组
//        char[] ch = new char[16];
////        int n = isr.read(ch, 0, 16);
//        int n = isr.read(ch);
//        while (n != (-1)){
////            osw.write(new String(ch, 0, n));
//            osw.write(ch, 0, n);
//            n = isr.read(ch);
//        }
//
////        4、关闭流(当使用处理流时，关闭外层高级流就可以，依然遵循后开先关)
//        osw.close();
//        isr.close();
//
//    }
//
//}



//try-catch(为了更好展示效果,去掉了注释代码,完整版如上)(工作中常用)(详细注释参考E38)
public class E42 {
    public static void main(String[] args)  {
//        功能:利用字节流复制文本文件
//        1、创建源文件对象和目标文件对象
//            创建源文件对象
        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "1.txt");
//            创建目标文件对象
        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "2.txt");

//        2、将源文件对象和输入流对象链接起来，目标文件和输出流链接起来
//        (在利用字符转换流时，输入或者输出都必须选择字符转换流对象，不能使用字符输入流接收或者输出文本内容，这点与原来设想有冲突)
////            将源文件与字符输入流链接
//        FileReader fr = new FileReader(f1);
////            将目标文件与字符输出流链接
//        FileWriter fw = new FileWriter(f2);
//            将源文件和字节输入流链接
        FileInputStream fis = null;
        FileOutputStream fos = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            fis = new FileInputStream(f1);
//            将目标文件与字节输出流链接
            fos = new FileOutputStream(f2);
//            将源文件与字符转换输入流链接
            isr = new InputStreamReader(fis, "utf-8" );         //需要添加编码格式
//            将目标文件和字符转换输出流链接
            osw = new OutputStreamWriter(fos);                              //需要添加编码格式

//        3、完成功能
//            缓冲数组
            char[] ch = new char[16];
//        int n = isr.read(ch, 0, 16);
            int n = isr.read(ch);
            while (n != (-1)){
//            osw.write(new String(ch, 0, n));
                osw.write(ch, 0, n);
                n = isr.read(ch);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//        4、关闭流(当使用处理流时，关闭外层高级流就可以，依然遵循后开先关)
            try {
                if(osw != null){
                    osw.close();
                }else {
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(isr != null){
                    isr.close();
                }else {
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
