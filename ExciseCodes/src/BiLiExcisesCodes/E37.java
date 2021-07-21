package BiLiExcisesCodes;

import java.io.File;

/**
 * @Auther: YS
 * @Date: 2021/7/5
 * @Description: IO流（File类对目录操作）
 * @Version: 1.0
 */
public class E37 {
    public static void main(String[] args) {
//        将目录封装成一个File对象
        File f1 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
        File.separator + "ExciseFiles");
        File f2 = new File("D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles" +  File.separator + "a" +  File.separator + "b" +  File.separator + "c");
        File f3 = new File("D:" +  File.separator );        //单选盘符时，要加上连接符

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

//        跟目录相关的方法
//        创建目录
//        f2.mkdir();         //在已存在的目录下增加一层新的目录
//        f2.mkdirs();          //在已存在的目录下增加多层新的目录
//        System.out.println("目录是否存在：" + f2.exists());

//        f2.delete();        //只会删除一层目录，且前提是该层目录为空，否则删除失败

//        查看
//        String[] l1 = f3.list();
////        遍历（增强For循环）
//        for(String s1 : l1){
//            System.out.println(s1);
//        }

        File[] l2 = f3.listFiles();         //该方法作用更大
        for(File f4 : l2){
            System.out.println("目录：" + f4.getPath() + "\t" + "目录名：" + f4.getName());
        }

    }
}
