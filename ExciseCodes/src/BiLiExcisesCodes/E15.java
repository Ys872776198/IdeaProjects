package BiLiExcisesCodes;

import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/5/5
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class E15 {
    public static void main(String[] args) {
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("请选择想要制作的pizza(1:培根披萨 2:海鲜披萨)");
            int flag = sc.nextInt();
            if(flag == 1)
            {
                System.out.println("请输入培根克数：");
                int a = sc.nextInt();
                System.out.println("请输入披萨大小：");
                int b = sc.nextInt();
                System.out.println("请输入披萨价格：");
                int c = sc.nextInt();

                Bacon bacon = new Bacon(b, c, "培根披萨", a);
                Pizza p = bacon;
                p.Show();
                bacon.Play();

            }else if(flag == 2)
            {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("请输入配料信息：");
                String a = sc1.nextLine();      //输入可以有空格，以enter键为结束符
//                System.out.println("a:" + a);

//                System.out.println("请输入配料信息：");
//                String a = sc.nextLine();     //输入不能有空格，空格为结束符，空格后面不能有东西
                System.out.println("请输入披萨大小：");
                int b = sc.nextInt();
                System.out.println("请输入披萨价格：");
                int c = sc.nextInt();

                Seafood seafood = new Seafood(b, c, "海鲜披萨", a);
                Pizza p = seafood;
                p.Show();
                seafood.Play();

            }else
            {
                /* Do Nothing */
            }
        }

//        test
//        Scanner sc = new Scanner(System.in);
//        System.out.print("请输入配料信息：");
//        String a = sc.nextLine();
//        System.out.println("a:" + a);
    }
}
