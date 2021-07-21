package BiLiExcisesCodes;

import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/5/9
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class E19 {
    public static void main(String[] args) {

        while(true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要购买的的饮品：1、可乐 2、咖啡 3、奶茶");
            int flag = sc.nextInt();

            if (flag == 1) {
                Drink d = new Coke();
                d.show();
            } else if (flag == 2) {
                Drink d = new Coffee();
                d.show();
            } else if (flag == 3) {
                Drink d = new Tea();
                d.show();
            } else {
//            do nothing
            }
        }
    }
}
