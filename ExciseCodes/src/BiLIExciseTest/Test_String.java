package BiLIExciseTest;

import java.util.Arrays;

/**
 * @Auther: YS
 * @Date: 2022/5/7 20:23
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class Test_String {
    public static void main(String[] args) {
//        String s = "中国";
//        byte[] b = s.getBytes();
//
//        System.out.println(Arrays.toString(b));

//        System.out.println(new String(new byte[]{-28, -72, -83, -27, -101, -67}));

//        System.out.println(new String(new char[]{'a', 'b', 'a', ' '}));

        StringBuilder s1 = new StringBuilder("afdhfahflsjjjj");

        s1.append("ffffff");

        s1.reverse();

        System.out.println(s1.toString());

        for(int a = 0; a < s1.toString().length(); a ++){
            System.out.print(s1.toString().charAt(a) + "\t");
        }

    }
}
