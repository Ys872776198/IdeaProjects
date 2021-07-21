package BiLiExcisesCodes;

/**
 * @Auther: YS (E10)
 * @Date: 2021/4/22
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class ClassTest {
    /**
    *功能描述：
    *@param     :测试类中的组成部分以及先后循序
    *@return    :
    *@auther    :
    *@data      :
    */

    private int age;
    private int sage;

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    private void setSage(int sage)
    {
        this.sage = sage;
    }

    private int getSage()
    {
        return sage;
    }

    public ClassTest()
    {
        System.out.println("空构造器");
    }

    {
        System.out.println("普通块");
    }

    static{
        System.out.println("静态块" );
    }

}
