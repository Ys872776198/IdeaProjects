package BiLiExcisesCodes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: YS
 * @Date: 2021/6/6
 * @Description: 集合（List）
 * @Version: 1.0
 */
public class E26 {
    public static void main(String[] args) {

//        list接口常用方法：
//            增加：add(int index, E element)
//            删除：remove(int index),remove(Object o)
//            修改：set(int index, E element)
//            查看：get(int index)
//            判断：

//        创建对象：接口不能创建对象，利用实现类来创建对象（多态）
        List l1 = new ArrayList();
//        List l2 = new ArrayList();

//        调用方法
//        调用方法:add,toString,isEmpty,size
        l1.add(18);
        l1.add(19);
        l1.add(10);
        l1.add("abc");
        l1.add(true);

//        l2.add(18);
//        l2.add(19);
//        l2.add(10);
//        l2.add("abc");
//        l2.add(true);

        System.out.println(l1);
        System.out.println(l1.isEmpty());
        System.out.println(l1.size());

//        调用方法:add(int index, E element),toString,isEmpty,size
//        l1.add(4,"flase");

//        System.out.println(l1);
//        System.out.println(l1.isEmpty());
//        System.out.println(l1.size());

//        调用方法:set(int index, E element),toString,isEmpty,size
//        l1.set(3,"wasd");

//        System.out.println(l1);
//        System.out.println(l1.isEmpty());
//        System.out.println(l1.size());

//        调用方法:remove(int index),toString,isEmpty,size
//        l1.remove(3);
//
//        System.out.println(l1);
//        System.out.println(l1.isEmpty());
//        System.out.println(l1.size());

//        调用方法:remove(Object o),toString,isEmpty,size
//        System.out.println(l1);
//        System.out.println(l1.isEmpty());
//        System.out.println(l1.size());
//
//        System.out.println(l1.remove("wasd"));
//
//        System.out.println(l1);
//        System.out.println(l1.isEmpty());
//        System.out.println(l1.size());

//        调用方法:get(int index),toString,isEmpty,size
//        Object ob1 = l1.get(1);
//
//        System.out.println(l1);
//        System.out.println(l1.isEmpty());
//        System.out.println(l1.size());
//        System.out.println(ob1);

//        集合的遍历（查看集合的元素）
//        1：普通For循环(存在获取集合中单个元素的办法)
//        for(int i = 0; i < l1.size(); i++){
//            System.out.println(l1.get(i));
//        }

//        2：增强For循环(因为集合中的数据不一定为Integer，所以使用Integer接收会报错。
//                为了应对这种情况，现在用Object接收数据，Object能接收所以类型数据)
//        for(Object i : l1){
//            System.out.println(i);
//        }

//        3：调用iterator方法(迭代器)
//        Iterator it =  l1.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }


    }

}
