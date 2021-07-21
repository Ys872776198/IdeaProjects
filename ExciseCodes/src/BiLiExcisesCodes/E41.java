package BiLiExcisesCodes;

import java.io.*;

/**
 * @Auther: YS
 * @Date: 2021/7/9
 * @Description: IO流(访问文件: BufferedReader和BufferedWiter(缓冲字符流,处理流))
 * @Version: 1.0
 */
//throws
//public class E41 {
//    public static void main(String[] args) throws IOException {
////        功能：利用缓冲字符流完成对文本文件的复制
////        1、创建源文件和目标文件的对象
////            创建源文件对象
//        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "1.txt");
////            创建目标文件对象
//        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "2.txt");
//
////        2、将源文件和输入流对象链接起来，将目标文件和输出流对象链接起来
////            将源文件和字符输入流对象链接
//        FileReader fr = new FileReader(f1);
////        将目标文件和字符输出流对象链接
//        FileWriter fw = new FileWriter(f2);
////        将字符输入流对象和缓冲字符输入流对象链接起来
//        BufferedReader br = new BufferedReader(fr);
////        将字符输出流对象和缓冲字符输出流对象链接起来
//        BufferedWriter bw = new BufferedWriter(fw);
//
////        3、完成功能
////            单个字符
////        int n = br.read();
////        while (n != (-1)){
////            bw.write(n);
////            n = br.read();
////        }
//
////            缓冲数组
////        char[] ch = new char[10];
////        int n = br.read(ch, 0, 10);         //返回的是读取的有效长度
//////        int n = br.read(ch);                  //不带参数，代表偏移量默认为0，读取长度为数组的长度（功能与上行相同）
////        while (n != (-1)){
////            bw.write(ch, 0, n);           //不带参数，代表偏移量默认为0，读取长度为数组的长度（功能与上行相同）
////            n = br.read(ch);
////        }
//
////            利用readLine()方法,按行读取
//        String s = br.readLine();
//        while (s != null){
//            System.out.println(s);
//            bw.write(s);
//            bw.newLine();               //要添加自动换行的方法,否则文本文件会堆在一行显示
//            s = br.readLine();
//        }
//
////        4、关闭流(当使用处理流时，关闭外层高级流就可以，依然遵循后开先关)
//        bw.close();
//        br.close();
//
//    }
//}


//try-catch(为了更好展示效果,去掉了注释代码,完整版如上)(工作中常用)(详细注释参考E38)
public class E41 {
    public static void main(String[] args) {
//        功能：利用缓冲字符流完成对文本文件的复制
//        1、创建源文件和目标文件的对象
//            创建源文件对象
        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "1.txt");
//            创建目标文件对象
        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "2.txt");

//        2、将源文件和输入流对象链接起来，将目标文件和输出流对象链接起来
//            将源文件和字符输入流对象链接
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            fr = new FileReader(f1);
//        将目标文件和字符输出流对象链接
            fw = new FileWriter(f2);
//        将字符输入流对象和缓冲字符输入流对象链接起来
            br = new BufferedReader(fr);
//        将字符输出流对象和缓冲字符输出流对象链接起来
            bw = new BufferedWriter(fw);

//        3、完成功能
//            利用readLine()方法,按行读取
            String s = br.readLine();
            while (s != null){
                bw.write(s);
                bw.newLine();               //要添加自动换行的方法,否则文本文件会堆在一行显示
                s = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
//        4、关闭流(当使用处理流时，关闭外层高级流就可以，依然遵循后开先关)
            try {
                if(bw != null){
                    bw.close();
                }else {
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(br != null){
                    br.close();
                }else {
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}