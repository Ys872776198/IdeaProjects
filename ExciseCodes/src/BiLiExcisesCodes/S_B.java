package BiLiExcisesCodes;

/**
 * @Auther: YS(E12)
 * @Date: 2021/4/29
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class S_B extends F_A {
    int sno;

    public S_B(){
        super();
    }

    public S_B(int sno){
        this.sno = sno;
    }

    public S_B(int age, String name, int sno){

//        this.age = age;
//        this.name = name;
//        this.sno = sno;

//        super.age = age;
//        super.name = name;
//        this.sno = sno;

        super(age,name);
        this.sno = sno;

//        this(sno);
//        super.age = age;
//        super.name = name;


        System.out.println("姓名：" + name + "年龄：" + age + "学号：" + sno);

    }

}
