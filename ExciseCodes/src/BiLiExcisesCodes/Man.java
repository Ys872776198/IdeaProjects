package BiLiExcisesCodes;

/**
 * @Auther: YS(E11)
 * @Date: 2021/4/26
 * @Description: 父类
 * @Version: 1.0
 */
public class Man {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println("我吃饭了");
    }

    public void excise(){
        System.out.println("我运动了");
    }

    public Man(){
//        空构造器
    }


}
