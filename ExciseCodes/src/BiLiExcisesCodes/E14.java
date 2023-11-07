package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/5/4
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class E14 {
    public static void main(String[] args) {
        Fish f = new Fish(5,2);
        Bird b = new Bird("红色", 4);

        Animal an = b;
        an.Introduction();
        b.Fly();
        /*
        * Bird b = (Bird) new Animal();     //向下转型（类似于强制转换）
        * */

        an = f;
        an.Introduction();
        f.Swing();

    }

}
