package BiLIExciseTest;

import com.mysql.cj.log.NullLogger;

import java.io.*;

/**
 * @Auther: YS
 * @Date: 2022/5/5 11:00
 * @Description: 字节流（万能流）
 * @Version: 1.0
 */
public class Test_FileIOSteam {
    public static void main(String[] args) {
//        1、创建IO流对象
//            文件的路径
        String filepathYT = "D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "1.txt";      //源文件

        String filepathMB = "D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "Copy_1.txt"; //目标文件

//        2、完成数据的传输
        FileInputStream fis = null;
        FileOutputStream fos = null;

//            创建缓冲输出输入流对象
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
/*
            fis = new FileInputStream(filepathYT);
            这么写的好处：
            1、自动创建了File对象
            2、自动将文件与IO流对接起来
            3、创建IO流对象
*/
            fis = new FileInputStream(filepathYT);
            fos = new FileOutputStream(filepathMB);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

//            利用缓冲数组来读写文件
            byte[] bytes = new byte[1024 * 8];
            int a;
//            while ((a = fis.read(bytes)) != (-1)){
//                fos.write(bytes, 0, a);
//            }

            while((a = bis.read(bytes)) != (-1)){
                bos.write(bytes, 0, a);
            }

//            判断文件是否存在
            File file = new File(filepathMB);
            System.out.println(file.exists());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//        3、关闭资源
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
//                do nothing
            }

            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
//                do nothing
            }
        }
    }
}
