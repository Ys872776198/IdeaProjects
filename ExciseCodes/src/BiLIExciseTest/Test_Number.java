package BiLIExciseTest;

import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2022/10/13 20:51
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class Test_Number {
    public static void main(String[] args) {
        double y = 0.0;     //本金
        int dn = 0;         //天数

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入本金：");
        y = sc.nextDouble();
        System.out.print("请输入天数：");
        dn = sc.nextInt();

        cal(y, dn);

    }

     //最低金额计算
    public static void cal(double a, int b){
        double lv = 0.98; //利率
        int d = 2;          //一天2次
        double lr = 0.0;    //利润

        for(int i = 1; i <= b; i++){
            for(int y = 1; y <= d; y++){
                //利润
                lr = ((a / 243) * lv);

                //本金加利润
                a = (a + lr);

                if(y % d == 1){
                    System.out.println("第" + i + "天本金加利润：" + a + " (中午13点)");
                    System.out.println("利润：" + lr);
                }else{
                    System.out.println("第" + i + "天本金加利润：" + a + " (下午19点)");
                    System.out.println("利润：" + lr);
                }
            }
        }

    }



}
