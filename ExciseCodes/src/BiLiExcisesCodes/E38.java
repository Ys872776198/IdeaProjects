package BiLiExcisesCodes;

import java.io.*;

/**
 * @Auther: YS
 * @Date: 2021/7/6
 * @Description: IO流(访问文件:FileReader和FileWriter)
 * @Version: 1.0
 */

////throws
//public class E38 {
//    public static void main(String[] args) throws IOException {
////        功能：文本文件的复制
////        1、有一个源文件，目标文件，输入流对象，输出流对象
////            创建源文件对象
//        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "1.txt");
//
////            创建目标文件对象(入参中的文件如果不存在,系统会根据路径自动创建)
//        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "2.txt");
//
////        2、将源文件和输入流对象链接起来，将目标文件和输出流对象链接起来
////            有异常要处理，暂时先进行Throws操作
//        FileReader fr = new FileReader(f1);
//        FileWriter fw = new FileWriter(f2);                 //不加参数,默认false
////        FileWriter fw = new FileWriter(f2,false);         //参数False代表写入文件开始处(覆盖)
////        FileWriter fw = new FileWriter(f2,true);          //参数true代表数据写入文件末尾处(追加)
//
////        3、完成读写操作
////            单个字符读取和写入
////        int n1 = fr.read();      //遍历字符，结尾返回-1
////        while(n1 != (-1)){
////            System.out.print(((char)n1));
////            fw.write(n1);        //单个字符写入
//
////            n1 = fr.read();      //遍历字符，结尾返回-1
////        }
//
//
////            用缓存数组来读取字符和写入字符
//        char[] ch = new char[10];
//        int n2 = fr.read(ch, 0,10);   //每次读取10个,方法的返回值为读取的 有效长度
////       int n2 = fr.read(ch);                     //read方法中直接加入char[]代表遍历长度为数组长度(实际效果与上条代码相同)
//
////        System.out.println(n2);
//       while(n2 != (-1)){
//
////           for(int i = 0; i < n2; i++){
////               System.out.print(ch[i]);             //根据返回数组的有效长度,遍历字符串
////           }
////
////           fw.write(ch);                     //此行代码有问题,没有达到预期
//           fw.write(ch, 0 , n2);           //将char[]数组写入到目标文件当中
//
////           String s1 = new String(ch, 0, n2);//将char[]转换为String,入参需要加入偏移量,和读取长度(此方法等价于For循环遍历Char[])
////           System.out.print(s1);
////
//////           fw.write(s1);
////           fw.write(s1, 0, n2);                //与上行代码效果一样
//
//
//
//           n2 = fr.read(ch, 0,10);   //每次读取10个,方法的返回值为读取的有效长度
////           n2 = fr.read(ch);                    //read方法中直接加入char[]代表遍历长度为数组长度(实际效果与上条代码相同)
//       }

////        4、关闭字符流（后用先关）(需要收到操作)
//        fw.close();
//        fr.close();
//    }
//}


//try-catch(为了更好展示效果,去掉了注释代码,完整版如上)(工作中常用)
public class E38 {
    public static void main(String[] args){
//        功能：文本文件的复制
//        1、有一个源文件，目标文件，输入流对象，输出流对象
//            创建源文件对象
        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "1.txt");

//            创建目标文件对象(入参中的文件如果不存在,系统会根据路径自动创建)
        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "2.txt");

//        2、将源文件和输入流对象链接起来，将目标文件和输出流对象链接起来
        FileReader fr = null;                   //局部变量一定要进行初始化
        FileWriter fw = null;
        try {
            fr = new FileReader(f1);            //需要将fr和fw的作用域提到try外面,否则会报错
            fw = new FileWriter(f2);

//        3、完成读写操作
//            用缓存数组来读取字符和写入字符
            char[] ch = new char[10];
            int n2 = fr.read(ch, 0,10);   //每次读取10个,方法的返回值为读取的有效长度

            while(n2 != (-1)){
                fw.write(ch, 0 , n2);           //将char[]数组写入到目标文件当中
                n2 = fr.read(ch, 0,10);   //每次读取10个,方法的返回值为读取的有效长度
            }
        } catch (FileNotFoundException e) {
        e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {              //finally中的代码无论上面是否抛出异常,都会执行
//        4、关闭字符流（后用先关）(需要收到操作)
            try {
                if (fw != null){                    //防止空指针异常(fr = new FileReader(f1)执行失败,导致fw始终为空,在执行close时会报错)
                    fw.close();                     //注意fw和fr的关闭要单独try-catch,不能合并在一起写,因为如果有一个报错,会导致另外一个没有关闭
                }else{
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fr != null){                    //防止空指针异常(fw = new FileWriter(f2)执行失败,导致fr始终为空,在执行close时会报错)
                    fr.close();
                }else{
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}