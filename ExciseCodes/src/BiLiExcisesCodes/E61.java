package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/22
 * @Description: Junit（接E61_Test）
 * @Version: 1.0
 */

//Junit属于白盒测试
/**
 * 在没有使用Junit的时候，缺点：
 * （1）测试一定走main方法，是程序的入口，main方法的格式必须不能写错。
 * （2）要是在同一个main方法中测试的话，那么不需要测试的东西必须注释掉。
 * （3）测试逻辑如果分开。需要定义多个测试类，比较麻烦。
 * （4）业务逻辑和测试代码，都混淆了。
 */

public class E61 {
    public int Add(int a, int b){
        System.out.println("相加的结果：" + (a + b));
        return (a + b);
    }

    public int Sub(int a, int b){
//        System.out.println("相减的结果：" + (a - b));
        return (a - b);
    }

}
