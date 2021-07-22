package BiLIExciseTest;

import BiLiExcisesCodes.E61;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: YS
 * @Date: 2021/7/22
 * @Description: Junit（接E61）
 * @Version: 1.0
 */
public class E61_Test {
    /**
     * 在测试方法下加一个@Test的注解
     * 需要导入Junit的包
     * 测试方法建议无参，无返回值
     * 可以加入断言：让时间结果和预期结果进行对比，判断代码是否运行正确
     *
     * 注解@Before：会在测试方法运行前执行
     * 一般会在@Before里面加一些申请资源的代码：申请数据库资源，申请IO资源，申请网络资源
     *
     * 注解@After：会在测试方法结束后执行
     * 一般会在@After里面加一些释放资源的代码：释放数据库资源，释放IO资源，释放网络资源
     *
     * 框架 = 注解 + 反射 + 设计结构
     *
     */

    @Before
    public void Strat(){
        System.out.println("测试方法开始了");
    }

    @After
    public void End(){
        System.out.println("测试方法结束了");
    }

    @Test
    public void AddTest(){
        E61 e = new E61();
        Assert.assertEquals(60, e.Add(50, 10));         //入参: 预测结果，实际结果
    }

    @Test
    public void SubTest(){
        E61 e = new E61();
        e.Sub(50, 10);
        Assert.assertEquals(60, e.Sub(50, 10));         //入参: 预测结果，实际结果
    }


}
