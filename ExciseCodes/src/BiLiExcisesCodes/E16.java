package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/5/6
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class E16 {
    public static void main(String[] args) {
        F_people1 p = new Student();
//        p.eat();//由于对象被static修饰，所以导致被修饰的方法先于对象存在，因此该方法无法被重写，需要调用子类最好方法就是类名.方法名（例F_people1.eat或者Student.eat()）
        F_people1.eat();
        Student.eat();

        int a = (int)((Math.random() * 11) + 20);
        System.out.println("a:" + a);

    }


}
