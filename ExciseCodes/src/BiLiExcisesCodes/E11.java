package BiLiExcisesCodes;

import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/4/25
 * @Description: 继承
 * @Version: 1.0
 */
public class E11 {

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = (int)(Math.random() * 101);


        Man_student s1 = new Man_student("哈哈", 18, 20);
        System.out.println("姓名:" + s1.getName()+ "\n" + "年龄:" + s1.getAge() + "\n" + "学号:" + s1.getSno());
    }

}
