package BiLIExciseTest;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Auther: YS
 * @Date: 2022/5/18 17:03
 * @Description: 把Arralist集合当中的数据读入到文本文件中
 * @Version: 1.0
 */
public class Test_ArrayListAndBufferedRW {
//    集合到文件
//    public static void main(String[] args) {
//        String filepathMB = "D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "2.txt"; //目标文件
//
//        FileWriter fw = null;
//        BufferedWriter bw = null;
//
//        try {
//            fw = new FileWriter(filepathMB, true);
//            bw = new BufferedWriter(fw);
//
//            ArrayList<String> al = new ArrayList<>();
//            al.add("nene");
//            al.add("-------------------");
//            al.add("lele");
//            al.add("-------------------");
//            al.add("lili");
//            al.add("-------------------");
//            al.add("haha");
//            al.add("-------------------");
//
////            遍历Arraylist
////            Iterator<String> ir = al.iterator();
////            if(ir.hasNext()){
////                String next = ir.next();
////            }
//            for(String s : al){
//                bw.write(s);
//                bw.newLine();
//                bw.flush();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (bw != null){
//                try {
//                    bw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }else{
////                do nothing
//            }
//        }
//    }

//    文件到集合
//    public static void main(String[] args) {
//        String filepathYT = "D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "2.txt";      //源文件
//
//        FileReader fr = null;
//        BufferedReader br = null;
//
//        try {
//            fr = new FileReader(filepathYT);
//            br = new BufferedReader(fr);
//
//            ArrayList<String> al = new ArrayList<>();
//
//            String str;
//
//            while(  (str = br.readLine()) != null){
//                al.add(str);
//            }
//
//            System.out.println(al);
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally{
//            if (br != null){
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }else{
////                do nothing
//            }
//        }
//    }

//    随机点名


}
