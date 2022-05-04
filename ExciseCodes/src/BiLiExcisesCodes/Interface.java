package BiLiExcisesCodes;

/**
 * @Auther: YS(E18)
 * @Date: 2021/5/6
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public interface Interface {
    public static final int NUM1 = 10;
    public static final int NUM2 = 20;

    public abstract void eat(Interface i1);

    public abstract void play();

    public default void watch(){
        System.out.println("我有一个手表！");
    }

    public static void water(){
        System.out.println("我想喝水！");
    }



}

interface Interface2{
    public abstract void fly();

    public default void Book(){
        System.out.println("龙族");
    }

}

abstract class F_test1{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void swming();

}

class Test1 extends F_test1 implements Interface, Interface2 {
    public void eat(Interface i1){
        System.out.println("我会吃饭！");
//        {
//            watch();
//            Interface.super.watch();        //这是普通块
//        }
     }

    {
        watch();
        Interface.super.watch();        //这是构造块
    }


    static {
        Interface.water();
    }

    public void play(){
        System.out.println("我会打游戏！");
    }

    public void swming(){
        System.out.println("我会游泳！");
    }

    public void fly(){
        System.out.println("我会飞！");
    }

    public F_test1 Ft(){
        F_test1 t2 = new Test1();
        return t2;
    }

}