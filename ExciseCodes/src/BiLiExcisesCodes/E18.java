package BiLiExcisesCodes;

import java.sql.SQLOutput;

/**
 * @Auther: YS
 * @Date: 2021/5/6
 * @Description: 接口
 * @Version: 1.0
 */
public class E18 {
    public static void main(String[] args) {
        Test1 t3 = new Test1();

//        访问接口常量
        System.out.println(Interface.NUM1);
        System.out.println(Test1.NUM2);
        System.out.println(new Test1().NUM1);
        Interface i1 = new Test1();
        System.out.println(i1.NUM2);

//        访问接口方法（Interface i1 = new Test1();）
        i1.eat(i1);
        i1.play();
        Interface2 i2 = new Test1();
        i2.fly();
        F_test1 t1 = t3.Ft();
        t1.swming();
        t3.Ft().swming();


    }
}
