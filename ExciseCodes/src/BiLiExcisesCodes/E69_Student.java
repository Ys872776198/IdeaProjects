package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/30
 * @Description: （接E71,E72,E73,E74）
 * @Version: 1.0
 */
@E69_Annotation(value = "类")
public class E69_Student extends E69_Person implements Interface2 {             //只需要重写接口里面的抽象方法
//    定义不同作用域的属性
    private String sno;
    int score;
    protected static String sex;

    @E69_Annotation(value = "属性")
    public String classroom;

//    定义不同作用域的方法
    private void Look(){
        System.out.println("我看书");
        System.out.println("我的权限修饰符是private");
    }

    @E69_Annotation(value = "方法")
    void Learn(){
        System.out.println("我学习");
        System.out.println("我的权限修饰符是default");
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "E69_Student{" +
                "sno='" + sno + '\'' +
                ", score=" + score +
                ", sex='" + sex + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }

    protected void Drink(String s) throws RuntimeException{
        System.out.println("我的权限修饰符是protected");
        System.out.println("我在喝" + s);
    }

    public String Multi(int a, int b){
        return ("我的权限修饰符是public,计算结果：" + a + " * " + b + "=" + (a * b));
    }

    @E69_Annotation(value = "静态方法")
    public static String Division(int a, int b){
        return ("我的权限修饰符是public,另外我加了static，计算结果：" + a + " / " + b + "=" + (int)(a / b));
    }

//    定义不同作用域的构造方法
    private E69_Student(String sno){
    System.out.println("我的权限修饰符是private");
    this.sno = sno;
}

    E69_Student(int score){
        System.out.println("我的权限修饰符是default");
        this.age = score;
    }

    protected E69_Student(String sex, String classroom){
        System.out.println("我的权限修饰符是protected");
        this.sex = sex;
        this.classroom = classroom;
    }

    public E69_Student(String sno, int score, String sex, String classroom){
        System.out.println("我的权限修饰符是public");
        this.sno = sno;
        this.score = score;
        this.sex = sex;
        this.classroom = classroom;
    }

    public E69_Student(){

    }

    @E69_Annotation(value = "重写方法")
    @Override
    public void fly() {
        System.out.println("大鹏一日同风起");
    }
}
