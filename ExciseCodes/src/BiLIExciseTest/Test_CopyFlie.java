package BiLIExciseTest;

import java.io.*;

/**
 * @Auther: YS
 * @Date: 2022/7/18 10:16
 * @Description: IntelliJ IDEA复制单级或者多级文件夹
 * @Version: 1.0
 */
public class Test_CopyFlie {
//    /**
//     * 1、复制单级文件夹:
//     *         1、创建源文件File对象，获取文件夹名称
//     *         2、创建目标文件File对象，根据获取的 源文件 的文件夹名称，创建目标文件的文件夹
//     *         3、判断目标文件夹是否存在，不存在就创建
//     *         4、获取File数组，遍历文件夹的所有内容
//     *         5、获取源文件每个File对象的名称
//     *         6、根据源文件File对象名称，创建目标文件File对象的名称
//     *         7、将文件夹内容复制过去(由于稳健内容不全是文档，因此选择字节流处理)
//     *         8、关闭资源
//      */
//
//    public static void main(String[] args) {
//        String yt = "D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
//                File.separator + "ExciseFiles" +  File.separator + "test1";
//
//        String mb = "D:" +  File.separator + "游戏系列";
//
////        创建源文件File对象，获取文件夹名
//        File ytf = new File(yt);
//        String ytfName = ytf.getName();
//
////        创建目标文件File对象,根据源文件的文件夹名称，创建目标文件的文件夹
//        File mbf = new File(mb, ytfName);
//
//        if (!mbf.exists()){
//            mbf.mkdir();
//        } else {
////            do nothing
//        }
//
////        获取File数组
//        File[] ytfArr = ytf.listFiles();
//
////        遍历源文件夹的所有内容
//        for (File f  : ytfArr){
////            获取源文件名称
//            String fName = f.getName();
////            创建目标文件夹的目标文件
//            File mbfile = new File(mbf, fName);
//
//            CopyFile(f, mbfile);
//        }
//
//    }
//
//    private static void CopyFile(File f, File mbfile) {
////        创建缓冲字节流
//        BufferedInputStream bis = null;
//        BufferedOutputStream bos = null;
//
//        try {
//            bis = new BufferedInputStream(new FileInputStream(f));
//            bos = new BufferedOutputStream(new FileOutputStream(mbfile));
//
////            复制文件
//            byte[] len = new byte[1024 * 8];
//            int n;
//            if ((n = bis.read(len)) != (-1)){
//                bos.write(n);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (bis != null){
//                    bis.close();
//                }else{
////                    do nothing
//                }
//                if (bos != null){
//                    bos.close();
//                }else{
////                    do nothing
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}

    /**
     * 1、复制多级文件夹:( 重点是需要给目标文件一个文件名，才能复制内容 )
     *         1、创建源文件File对象，获取文件夹名称
     *         2、创建目标文件File对象，根据获取的 源文件 的文件夹名称，创建目标文件的文件夹
     *         3、判断目标文件夹是否存在，不存在就创建
     *         4、获取File数组，遍历文件夹的所有内容
     *         5、判断当前File对象是否为文件夹，若是文件夹，则极限遍历文件夹，直到文件不是文件夹为止（利用递归）
     *         6、获取源文件每个File对象的名称
     *         7、根据源文件File对象名称，创建目标文件File对象的名称
     *         8、将文件夹内容复制过去(由于稳健内容不全是文档，因此选择字节流处理)
     *         9、关闭资源
     */

    public static void main(String[] args) {
        String yt = "D:" +  File.separator + "CodeProject" +  File.separator + "IdeaProjects" +
                File.separator + "ExciseFiles";
        String mb = "D:" +  File.separator + "游戏系列";

//        创建源文件File对象，获取文件夹名
        File ytf = new File(yt);
        String ytfName = ytf.getName();

//        创建目标文件File对象,根据源文件的文件夹名称，创建目标文件的文件夹
        File mbf = new File(mb, ytfName);
//        判断文件是否存在
        if (!mbf.exists()){
            mbf.mkdir();
        } else {
//            do nothing
        }

//        获取File数组
        File[] ytfArr = ytf.listFiles();

//        遍历源文件夹的所有内容
        for (File f  : ytfArr){
//        判断问文件是否为目录
//            if (f.isDirectory()){
                RecFile(f, mbf);
//            } else {
//                do nothing
//            }
        }
    }

    private static void RecFile(File f, File mbf) {
//        判断问文件是否为目录
        if (f.isDirectory()){
//        获File对象文件名
            String fName2 = f.getName();
//        创建目标文件File对象
            File mbfile2 = new File(mbf, fName2);
//            判断文件是否存在
            if (!mbfile2.exists()){
                mbfile2.mkdir();
            } else {
//            do nothing
            }

//        获取File数组
            File[] ytf2 = f.listFiles();

//        遍历源文件夹的所有内容
            for (File f2 : ytf2){
//                判断问文件是否为目录
//                if (f2.isDirectory()){
                    RecFile(f2, mbfile2);
//                } else {
//                    CopyFile(f2, mbfile2);
//                }
            }
        } else {
//            File f2 = new File(mbf, f.getName());
            CopyFile(f, new File(mbf, f.getName()));
        }
    }

    private static void CopyFile(File f, File mbfile) {
//        创建缓冲字节流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(f));
            bos = new BufferedOutputStream(new FileOutputStream(mbfile));

//            复制文件
            byte[] len = new byte[1024 * 8];
            int n;
            if ((n = bis.read(len)) != (-1)){
                bos.write(n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null){
                    bis.close();
                }else{
//                    do nothing
                }
                if (bos != null){
                    bos.close();
                }else{
//                    do nothing
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}