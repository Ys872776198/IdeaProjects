package BiLiExcisesCodes;

/**
 * @Auther: YS(E13)(E14)
 * @Date: 2021/5/3
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */

//    E13
//public class Animal {
//
//    public void Shout(){
//        System.out.println("我是动物，我会叫。。");
//    }
//
//}

//    E14
public class Animal {
    private int age;

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public Animal(){

    }

    public void Introduction(){
        System.out.println("我是个动物");
        System.out.println("今年我" + this.getAge() + "岁了！");
    }

}