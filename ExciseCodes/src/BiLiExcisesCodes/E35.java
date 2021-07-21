package BiLiExcisesCodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @Auther: YS
 * @Date: 2021/7/1
 * @Description: Collections工具类
 * @Version: 1.0
 */
public class E35 {
    public static void main(String[] args) {
//        collections不支持创建对象，因为构造器私有化了
//        collections里面属性和方法都被static修饰，可以直接使用类名.方法名调用
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();

//        常用方法：addAll（可以往数组里面同时添加多组数据）
        Collections.addAll(a1, 13,15,16,10,19);
        Collections.addAll(a1, new Integer[]{20, 26, 30});
//        System.out.println(a1);

//        binarySearch(二分法查找)
//        System.out.println(Collections.binarySearch(a1, 20));

//        排序（升序）
//        Collections.sort(a1);
//        System.out.println(Collections.binarySearch(a1, 30));

//        Copy
        Collections.addAll(a2,40, 0, 50);
//        Collections.copy(a1, a2);
//        System.out.println(a1);

//        fill
        Collections.fill(a1, 40);
        System.out.println(a1);
    }
}
