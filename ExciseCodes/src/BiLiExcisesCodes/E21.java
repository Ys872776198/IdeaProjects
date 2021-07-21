package BiLiExcisesCodes;

import java.util.Date;

/**
 * @Auther: YS
 * @Date: 2021/5/13
 * @Description: 包装类(以Integer为例)
 * @Version: 1.0
 */
public class E21 {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        自动装箱
//        Integer i1 = 130;
//        System.out.println(i1.toString());

//        自动拆箱
//        int i2 = new Integer(120);
//        System.out.println(i2);

//        Integer i3 = new Integer(130);
//        Integer i4 = new Integer(130);
        Integer i3 = 120;
        Integer i4 = 120;
        //自动装箱：当比较数值在-128~127之间时，比较的就是数值，不在这个范围比较的就是数据的地址
        System.out.println(i3 == i4);       //“==”比较的是地址
        System.out.println(i3.equals(i4));

    }


}
