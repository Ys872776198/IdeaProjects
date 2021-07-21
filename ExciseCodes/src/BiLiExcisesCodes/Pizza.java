package BiLiExcisesCodes;

/**
 * @Auther: YS(E15)
 * @Date: 2021/5/5
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public abstract class Pizza {
    private String name;
    private int price;
    private int size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Pizza(){

    }

    public abstract void Show();


}
