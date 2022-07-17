package BiLIExciseTest;

import java.io.*;

/**
 * @Auther: YS
 * @Date: 2022/5/7 21:05
 * @Description: 缓冲字符流（现实当中最常用）
 * @Version: 1.0
 */
public class Test_BufferedRW {
    public static void main(String[] args) {
        /*
        * 1、创建原文件对象
        * 2、创建目标文件对象
        * 3、实现读写操作
        * 4、关闭流
        * */

        String filepathYT = "D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "1.txt";      //源文件

        String filepathMB = "D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "Copy_1.txt"; //目标文件

        FileReader fr = null;
        FileWriter fw = null;

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            fr = new FileReader(filepathYT);
            fw = new FileWriter(filepathMB);

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

//            一行一行读取
            String s;
            while((s = br.readLine()) != null){
                bw.write(s);
                bw.newLine();
                bw.flush();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
//                do nothing
            }

            if(br != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
//                do nothing
            }

        }

    }
}
