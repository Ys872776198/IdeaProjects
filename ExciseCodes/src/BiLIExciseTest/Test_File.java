package BiLIExciseTest;

import java.io.File;
import java.io.IOException;

/**
 * @Auther: YS
 * @Date: 2022/5/4 16:55
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class Test_File {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:" + File.separator );

        File[] fs = f1.listFiles();
        for(File f2 : fs){
            if(f2.isDirectory()){
                System.out.println(f2.getAbsolutePath());
            }else{
//                do nothing
            }
        }
    }

}
