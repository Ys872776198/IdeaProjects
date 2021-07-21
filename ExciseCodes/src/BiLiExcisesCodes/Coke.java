package BiLiExcisesCodes;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @Auther: YS(E19)
 * @Date: 2021/5/9
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class Coke extends Drink{
    public Coke(){
        this.setName("可乐");
        System.out.println("请录入你需要的可乐的信息：");
        Scanner sc = new Scanner(System.in);

        System.out.println("备注可乐是选择百事可乐还是可口可乐，是否加冰：");
        this.setRemarks(sc.nextLine());

        System.out.println("选择杯型：1、中杯 2、大杯 3、超大杯");
        int flag = sc.nextInt();
        if(flag == 1){
            this.setSize("中杯");
            this.setUnit(10);
        }else if(flag == 2){
            this.setSize("大杯");
            this.setUnit(12);
        }else if(flag == 3){
            this.setSize("超大杯");
            this.setUnit(15);
        }else {
//                do nothing
        }

        System.out.println("购买数量：");
        this.setQuantity(sc.nextInt());
    }



//    public void show(String name,String remarks, String size, int quantity)
    public void show()
    {
//        this.setName(name);
//        this.setRemarks(remarks);
//        this.setSize(size);
//        this.setQuantity(quantity);

        System.out.println("订单消息：您购买的是：" + this.getName());
        System.out.println("备注：" + this.getRemarks());
        System.out.println("杯型：" + this.getSize());
        System.out.println("购买数量：" + this.getQuantity());
        System.out.println("价格：" + this.getUnit() + " * " + this.getQuantity() + " = " + (this.getUnit() * this.getQuantity()));
    }

}
