package BiLiExcisesCodes;

/**
 * @Auther: YS(E17)
 * @Date: 2021/5/6
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public abstract class F_people2 {
    public abstract void eat();

    public void paly(){
        System.out.println("我爱运动！");
    }
}
class Student1 extends F_people2 {
    public void eat(){
        System.out.println("我想吃饭！");
    }
}