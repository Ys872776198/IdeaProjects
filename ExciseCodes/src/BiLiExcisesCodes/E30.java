package BiLiExcisesCodes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @Auther: YS
 * @Date: 2021/6/23
 * @Description: LinkedList
 * @Version: 1.0
 */
public class E30 {
    public static void main(String[] args) {
//        LinkedList常用方法
//        增加：   addFirst(E e), addLast(E e), offer(E e), offerFirst(E e), offerLast(E e)
//        删除：   poll(), pollFirst(), pollLast(), removeFirst(), removeLast()
//        修改：
//        查看：   element(), getFirst(), getLast(), indexOf(Object o), lastIndexOf(Object o), peek(), peekFirst(), peekLast(),
//        判断：

//        创建一个LinkedList集合对象
        LinkedList<String> l1 = new LinkedList<>();

//        1、方法：add, addFirst(E e), addLast(E e)
//        l1.add("aa");
//        l1.add("bb");
//        l1.add("cc");
//        l1.add("dd");
//        l1.add("ee");
//        l1.add("ff");
//        System.out.println(l1);
//        System.out.println("-------------------------");
//
//        l1.addFirst("gg");
//        System.out.println(l1);
//        System.out.println("-------------------------");
//
//        l1.addLast("hh");
//        System.out.println(l1);
//        System.out.println("-------------------------");

//        2、方法：add, offer(E e), offerFirst(E e), offerLast(E e)
//        l1.add("aa");
//        l1.add("bb");
//        l1.add("cc");
//        l1.add("dd");
//        l1.add("ee");
//        l1.add("ff");
//        System.out.println(l1);
//        System.out.println("-------------------------");
//
//        l1.offer("gg");         //最后
//        System.out.println(l1);
//        System.out.println("-------------------------");
//
//        l1.offerFirst("hh");
//        System.out.println(l1);
//        System.out.println("-------------------------");
//
//        l1.offerLast("ii");
//        System.out.println(l1);
//        System.out.println("-------------------------");

//        3、方法：add, poll(), pollFirst(), pollLast(), removeFirst(), removeLast()
//          方法pollFirst()和removeFirst(), pollLast()和removeLast()功能一样，
//          不同点就是，当集合没有成员时，使用方法pollFirst(), pollLast()会返回null,这样提高了代码的健壮性
//          但是，使用方法removeFirst(), removeLast()会报错
//
//        l1.add("aa");
//        l1.add("bb");
//        l1.add("cc");
//        l1.add("dd");
//        l1.add("ee");
//        l1.add("ff");
//        System.out.println(l1);
//        System.out.println("-------------------------");
//
//        System.out.println(l1.poll());
//        System.out.println(l1);
//        System.out.println("-------------------------");
//
//        l1.pollFirst();
//        System.out.println(l1);
//        System.out.println("-------------------------");
//
//        l1.pollLast();
//        System.out.println(l1);
//        System.out.println("-------------------------");
//
//        l1.removeFirst();
//        System.out.println(l1);
//        System.out.println("-------------------------");
//
//        l1.removeLast();
//        System.out.println(l1);
//        System.out.println("-------------------------");

//        遍历
//        l1.add("aa");
//        l1.add("bb");
//        l1.add("cc");
//        l1.add("dd");
//        l1.add("ee");
//        l1.add("ff");
//        System.out.println(l1);
//        System.out.println("-------------------------");

//        1、普通for循环
//        for(int i = 0; i < l1.size(); i++){
//            System.out.println(l1.get(i));
//        }

//        2、增强for循环(如果在创建对象是指定了泛型参数，那么就用指定的泛型参数作为接收的数据类型。如果没有指定，那么就用Object数据类型接收)
//        for(String s : l1){
//            System.out.println(s);
//        }

//        3、迭代器Iterator
//        Iterator<String> it = l1.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

//        Iterator<String> it = l1.iterator()为集合的第一个成员
//        it.hasNext()为判定条件，当集合下一个空间存在成员时，返回true
//        使用it.next()方法时，指针会自动下移
//        for(Iterator<String> it = l1.iterator(); it.hasNext();){
//            System.out.println(it.next());
//        }

//        迭代器ListIterator
        l1.add("aa");
        l1.add("bb");
        l1.add("cc");
        l1.add("dd");
        l1.add("ee");
        l1.add("ff");
        System.out.println(l1);
        System.out.println("-------------------------");

//        想在"cc"后面添加"GG"
//        使用迭代器Iterator完成这个操作时会出现ConcurrentModificationException(并发修改异常)
//        原因：因为迭代器it1和l1同时对集合操作
//        解决方法：使用迭代器ListIterator，所有操作让迭代器ListIterator一个进行操作

//        Iterator<String> it1 = l1.iterator();
//        while(it1.hasNext()){
//            if("cc".equals(it1.next())){
//                l1.add("GG");                 //错误原因
//            }else{
////                do nothing
//            }
//
//            it1.next();
//        }

        ListIterator<String> it2 = l1.listIterator();
        while(it2.hasNext()){
            if("cc".equals(it2.next())){
                it2.add("GG");                  //由于所有的操作都由一个迭代器it2完成，因此此次调用add方法也是it2
            }else{
//                do nothing
            }
        }

        System.out.println(l1);
        System.out.println("-------------------------");

//        倒叙遍历
//        while(it2.hasPrevious()){
//            System.out.println(it2.previous());
//        }

    }

}
