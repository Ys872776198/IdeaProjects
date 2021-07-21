package BiLiExcisesCodes;

/**
 * @Auther: YS(E19)
 * @Date: 2021/5/9
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public abstract class Drink {
    private String name;
    private int price;
    private String size;
//    private String ice;
    private int quantity;
    private String remarks;
    private int unit;

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

//    public String getIce() {
//        return ice;
//    }
//
//    public void setIce(String ice) {
//        this.ice = ice;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Drink(){}

//    public abstract void show(String name,String remarks, String size, int quantity);

    public abstract void show();

}
