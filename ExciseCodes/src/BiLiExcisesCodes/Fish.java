package BiLiExcisesCodes;

/**
 * @Auther: YS(E14)
 * @Date: 2021/5/4
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class Fish extends Animal {
    private int weight;

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public Fish(int weight,int age){
        this.setWeight(weight);
        this.setAge(age);
    }

    public void Swing(){
        System.out.println("我在水里吐泡泡！");
    }

    public void Introduction(){
        System.out.println("我是一只" + this.getWeight() + "公斤的鱼！");
        System.out.println("我今年" + this.getAge() + "岁了！" );
    }

}
