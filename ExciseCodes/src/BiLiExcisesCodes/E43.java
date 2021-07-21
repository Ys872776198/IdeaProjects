package BiLiExcisesCodes;

import java.io.*;
import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/7/9
 * @Description: System类对IO流的支持 和 作业
 * @Version: 1.0
 */
public class E43 {
    public static void main(String[] args) throws IOException {
//        System类对IO流的支持
//            System.in:标准输入流，默认情况，从键盘录入
//            Scanner是扫描器，扫描指定的输入流
//            Scanner sc = new Scanner(new FileReader("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                    File.separator + "ExciseFiles" +  File.separator + "1.txt"));
//            while (sc.hasNext()){
//                System.out.println(sc.nextLine());              //next方法是以空格键喂结束符，nextLine方法以换行键为结束符
//            }
//
//            System.out:标准输出流，默认情况输出到控制台
//            PrintStream out = System.out;
//            out.println("haoeufhoaheofhaoehfoaheofhaoehfahei");         //等于 System.out.println();  换行
//            out.print("hiehfiahfiheafheihfaheifhhafahfoiha");           //等于 System.out.print();    不换行
//            System.out.println();
//
////        作业：键盘录入信息在转到文件中（功能实现）
////        1、创建目标文件对象
//        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "3.txt");
//
////        2、将目标文件与字符转换输入流链接
//
//        FileOutputStream fos = null;
//        OutputStreamWriter osw = null;
//        try {
////            将目标文件与字节输出流链接起来
//            fos = new FileOutputStream(f1);
////            将字节输出流与字符转换输出流链接起来
//            osw = new OutputStreamWriter(fos);
//
////        3、完成功能
////            扫描器对象
//            Scanner sc = new Scanner(System.in);
//            System.out.println("请开始你的表演:");
//            String s = sc.nextLine();
//
//            osw.write(s);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
////        4、关闭流
//            try {
//                if(osw != null){
//                    osw.close();
//                }else {
////                    do nothing
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        作业：键盘录入信息在转到文件中（提高效率）
//        1、目标文件对象
//            目标文件对象
        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "3.txt");

//        2、将源文件对象与输入流链接起来，将目标文件与输出流连接起来
//            将键盘录入的信息与字符转换流链接起来
        InputStream in = System.in;             //属于字节流
        InputStreamReader isr = new InputStreamReader(in, "utf-8");
//            提高效率将字符转换流与字符缓冲输入流连接起来
        BufferedReader br = new BufferedReader(isr);
//            将目标文件对象与字符输出流连起来
        FileWriter fw = new FileWriter(f2);
//            提高效率,将字符输出流和字符缓冲流链接起来
        BufferedWriter bw = new BufferedWriter(fw);

//        3、完成功能
        String s = br.readLine();
        while (!s.equals("end")){
            bw.write(s);
            bw.newLine();
            s = br.readLine();
        }

//        4、关闭流
        bw.close();
        br.close();
    }
}
