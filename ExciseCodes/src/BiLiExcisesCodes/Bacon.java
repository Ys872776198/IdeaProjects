package BiLiExcisesCodes;

/**
 * @Auther: YS(E15)
 * @Date: 2021/5/5
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class Bacon extends Pizza {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Bacon(int size, int price, String name,int weight){
        super.setSize(size);
        super.setPrice(price);
        super.setName(name);
        this.setWeight(weight);
    }

    public void Show(){
        System.out.println("名称：" + super.getName());
        System.out.println("价格：" + super.getPrice() + "元");
        System.out.println("大小：" + this.getSize() + "寸");

    }

    public void Play(){
        System.out.println("培根克数：" + this.getWeight());
    }

}
