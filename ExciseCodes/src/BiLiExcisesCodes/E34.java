package BiLiExcisesCodes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: YS
 * @Date: 2021/7/1
 * @Description: Map(HashMap)
 * @Version: 1.0
 */
public class E34 {

}

class E34_Main{
    public static void main(String[] args) {
//        Map常用方法
//        增加：   put(K key, V value)
//        删除：   clear(), remove(Object key)
//        修改：
//        查看：   entrySet(), get(Object key), keySet(), size(), values()
//        判断：   containsKey(Object key), containsValue(Object value), equals(Object o), isEmpty()

//        创建Map的集合
        Map<Integer, String> m1 = new HashMap<>();

//        方法：put(K key, V value), size()
        m1.put(2134, "lili");
        m1.put(2135, "lili");
        m1.put(2136, "lila");
        m1.put(2137, "lilb");
        m1.put(2138, "lilc");
        m1.put(2134, "lili");

//        System.out.println(m1.size());
//        System.out.println(m1);
//        System.out.println("--------------------------");

//        方法：size(), clear(), remove(Object key)
//        System.out.println(m1.remove(2138));
//        System.out.println(m1.size());
//        System.out.println(m1);
//        System.out.println("--------------------------");
//
//        m1.clear();
//        System.out.println(m1.size());
//        System.out.println(m1);
//        System.out.println("--------------------------");

//        方法：size(), containsKey(Object key), containsValue(Object value), equals(Object o), isEmpty()
//       在创建一个Map集合
//        Map<Integer, String> m2 = new HashMap<>();
//
//        m2.put(2134, "lili");
//        m2.put(2135, "lili");
//        m2.put(2136, "lila");
//        m2.put(2137, "lilb");
//        m2.put(2138, "lilc");
//        m2.put(2134, "lild");
//
//        System.out.println(m1.size());
//        System.out.println(m1);
//        System.out.println("--------------------------");
//
//        System.out.println(m1.containsKey(2138));
//
//        System.out.println(m1.containsValue("lilc"));
//
//        System.out.println(m1.equals(m2));
//
//        System.out.println(m1.isEmpty());
//
//        m1.clear();
//        System.out.println(m1.size());
//        System.out.println(m1);
//        System.out.println("--------------------------");
//        System.out.println(m1.isEmpty());

//        方法：entrySet(), get(Object key), keySet(), values()
//        System.out.println(m1.get(2138));
//
////        遍历集合中value的值
//        Collection<String> v1 = m1.values();
//        for(String s : v1){
//            System.out.println(s);
//        }
//
////        遍历集合中key的值
//        Set<Integer> i1 = m1.keySet();
//        for(Integer i : i1){
//            System.out.println(i);
//        }

//        遍历集合中的Key和values
        Set<Map.Entry<Integer, String>> e1 = m1.entrySet();
        for(Map.Entry<Integer, String> m : e1){
            System.out.println(m.getKey() + "+" + m.getValue());
        }
        
    }
}