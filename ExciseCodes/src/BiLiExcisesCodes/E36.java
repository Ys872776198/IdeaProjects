package BiLiExcisesCodes;

import java.io.File;
import java.io.IOException;

/**
 * @Auther: YS
 * @Date: 2021/7/2
 * @Description: IO流（File类对文件操作）
 * @Version: 1.0
 */
public class E36 {
    public static void main(String[] args) throws IOException {
//        将文件封装成一个File对象
//        separator方法被static修饰，直接用类名.方法名调用,这个方法自动获取当前系统的链接符号
        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "1.txt");    //建议使用separator方法
        File f2 = new File("D:\\CodeProject\\IdeaProjects\\ExciseFiles\\1.txt");
        File f3 = new File("2.txt");

//        常用方法
//        System.out.println("文件是否可读：" + f1.canRead());
//        System.out.println("文件是否可执行：" + f1.canExecute());
//        System.out.println("文件是否可写：" + f1.canWrite());
//        System.out.println("文件名字：" + f1.getName());
//        System.out.println("文件路径：" + f1.getPath());
//        System.out.println("文件的上级目录：" + f1.getParent());
//        System.out.println("文件是否为一个目录：" + f1.isDirectory());
//        System.out.println("文件是否是隐藏文件：" + f1.isHidden());
//        System.out.println("文件是否是一个标准文件：" + f1.isFile());
//        System.out.println("文件的大小：" + f1.length());
//        System.out.println("文件是否存在：" + f1.exists());
//        System.out.println("文件的绝对路径：" + f1.getAbsolutePath());
//        System.out.println("文件的相对路径：" + f1.getPath());              //相对路径和toString的结果是一致的
//        System.out.println("toString：" + f1.toString());

//        if(!f1.exists()){           //文件不存在，就创建它
//            f1.createNewFile();     //抛出异常
//        }else{
//            f1.delete();            //存在就删除它
//        }
//        System.out.println("文件是否存在：" + f1.exists());

//        文件比较
//        System.out.println(f1 == f2);       //false,"=="比较的是地址，由于是两个对象，地址肯定不同
//        System.out.println(f1.equals(f2));  //true, 调用equals方法，比较的是路径

//        if(!f3.exists()){
//           f3.createNewFile();
//        }else{
////            do nothing
//        }

////        绝对路径是指一个文件的完整的路径
//        System.out.println("文件的绝对路径：" + f3.getAbsolutePath());
////        相对路径是指相对与"CodeProject\IdeaProjects"来说的
//        System.out.println("文件的相对路径：" + f3.getPath());              //相对路径和toString的结果是一致的
//        System.out.println("toString：" + f3.toString());





    }
}
