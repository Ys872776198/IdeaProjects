package BiLiExcisesCodes;

import com.sun.deploy.security.BadCertificateDialog;

import java.util.*;

/**
 * @Auther: YS
 * @Date: 2021/5/24
 * @Description: 集合（Collection）
 * @Version: 1.0
 */
public class E25 {
    public static void main(String[] args) {

//        Collection接口常用方法：
//            增加：add(E e),addAll(Collection<? extends E> c)
//            删除：clear(),remove(Object o)
//            修改：
//            查看：iterator(),size()
//            判断：contains(Object o),equals(Object o)

//        创建对象：接口不能创建对象，利用实现类来创建对象（多态）
        Collection col1 = new ArrayList();
        Collection col2 = new ArrayList();

//        调用方法
//        集合有个特点：只能存放引用数据类型的数据，不能存放基本类型的数据
//        基本数据类型会自动装箱成对于的包装类。例 int -> Integer
//        add,toString,isEmpty,size
        col1.add(18);
        col1.add(19);
        col1.add(10);
        col1.add("abc");
        col1.add(true);

        System.out.println(col1);
        System.out.println(col1.isEmpty());
        System.out.println(col1.size());

//        调用方法:addAll,asList,toString,isEmpty,size
//        多态
//        List list = Arrays.asList(new Integer[]{1, 2, 3});
//
//        col1.addAll(list);      //将一个集合添加到另一个集合当中
//        System.out.println(col1);
//        System.out.println(col1.isEmpty());
//        System.out.println(col1.size());

//        col2.add(18);
//        col2.add(19);
//        col2.add(11);
//        col2.add("abc");
//        col2.add(true);
//
//        System.out.println(col2);
//        System.out.println(col2.isEmpty());
//        System.out.println(col2.size());

//        调用方法:clear,toString,isEmpty,size
//        col2.clear();
//
//        System.out.println(col2);
//        System.out.println(col2.isEmpty());
//        System.out.println(col2.size());

//        调用方法:remove,toString,isEmpty,size
//        System.out.println(col1.remove(18));
//
//        System.out.println(col1);
//        System.out.println(col1.isEmpty());
//        System.out.println(col1.size());

//        调用方法:equals
//        System.out.println(col1.equals(col2));
//        System.out.println((col1 == col2));     //"=="比较的是地址，由于是两个不同的对象进行比较，因此对于的地址肯定不一样

//        调用方法:contains
//        System.out.println(col1.contains(18));
//        System.out.println(col1.contains(100));

//        集合的遍历（查看集合的元素）
//        1：普通For循环(无法完成，因为Collection接口没有提供获取单个成员的方法)
//        for(int i = 0; i < col1.size(); i++){
//            col1.
//        }

//        2：增强For循环(因为集合中的数据不一定为Integer，所以使用Integer接收会报错。
//        为了应对这种情况，现在用Object接收数据，Object能接收所以类型数据)
//        for(Object i : col1){
//            System.out.println(i);
//        }

//        3：调用iterator方法(迭代器)
//        Iterator it =  col1.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }



    }
}
