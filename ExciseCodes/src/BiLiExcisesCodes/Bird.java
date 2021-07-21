package BiLiExcisesCodes;

/**
 * @Auther: YS(E14)
 * @Date: 2021/5/4
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class Bird extends Animal {
    private String colour;

    public void setColour(String colour){
        this.colour = colour;
    }

    public String getColour(){
        return colour;
    }

    public  Bird(String colour, int age){
        this.setColour(colour);
        this.setAge(age);
    }

    public void Fly(){
        System.out.println("我展翅翱翔");
    }

    public void Introduction(){
        System.out.println("我是一只" + this.getColour() + "鸟！" );
        System.out.println("我今年" + this.getAge() +"岁了！");
    }

}
