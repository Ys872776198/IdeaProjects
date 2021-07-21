package BiLiExcisesCodes;

/**
 * @Auther: YS(E15)
 * @Date: 2021/5/5
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class Seafood extends Pizza {
    private String ingredients;

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Seafood(int size, int price, String name,String ingredients){
        super.setSize(size);
        super.setPrice(price);
        super.setName(name);
        this.setIngredients(ingredients);
    }

    public void Show(){
        System.out.println("名称：" + super.getName());
        System.out.println("价格：" + super.getPrice() + "元");
        System.out.println("大小：" + this.getSize() + "寸");

    }

    public void Play(){
        System.out.println("配料：" + this.getIngredients());
    }



}
