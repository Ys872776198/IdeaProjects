package BiLIExciseTest;

import BiLiExcisesCodes.E62;
import BiLiExcisesCodes.E62_Gender;
import org.junit.Test;

/**
 * @Auther: YS
 * @Date: 2021/7/26
 * @Description: 枚举（接E62）
 * @Version: 1.0
 */
public class E62_Test {
    @Test
    public void Test(){
        E62 e1 = new E62();                  //利用午餐构造器
        e1.setAge(10);
        e1.setName("nene");
        e1.setSex(E62_Gender.女);            //枚举调用方法，就是直接类名.成员名，如果成员名不存在枚举里面，程序会报错
        System.out.println(e1);

        E62 e2 = new E62("ys", 10, E62_Gender.男);                 //利用有参构造器
        System.out.println(e2);

        E62_Gender s = E62_Gender.女;        //枚举也可以创建对象，同时，在Enum类里面重写了toString方法
        System.out.println(s);
    }
}
