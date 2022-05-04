package BiLIExciseTest;

import java.security.PublicKey;
import java.util.*;

/**
 * @Auther: YS
 * @Date: 2022/4/1 22:35
 * @Description: 斗地主游戏（洗牌，发牌，排序，看牌）
 * @Version: 1.0
 */
public class Test_Collections {
    public static void main(String[] args) {
//        1、创建牌
//            创建HashMap集合对象 装牌
        HashMap<Integer, String> ph = new HashMap<>();
//            创建ArrayList集合对象   洗牌
        ArrayList<Integer> xp = new ArrayList<>();
////            创建TreeSet集合对象 排序 （单独创建方法）
//        TreeSet<Integer> px = new TreeSet<>(new Comparator<Integer>() { //利用匿名内部类，指定外部比较器
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return (o1 - o2);
//            }
//        });

//            创建打牌的三个人和底牌
        HashMap<Integer, String> a = new HashMap<>();   //用户A
        ArrayList<Integer> a1 = new ArrayList<Integer>();          //用户A装牌

        HashMap<Integer, String> b = new HashMap<>();   //用户B
        ArrayList<Integer> b1 = new ArrayList<Integer>();          //用户B装牌

        HashMap<Integer, String> c = new HashMap<>();   //用户C
        ArrayList<Integer> c1 = new ArrayList<Integer>();          //用户C装牌

        HashMap<Integer, String> dp = new HashMap<>();  //底牌
        ArrayList<Integer> dp1 = new ArrayList<Integer>();         //装底牌

//            记牌器
        int i = 0;
//            牌色
        String[] color = {"♦", "♣", "♥", "♠"};
//            数值
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
//            jack
        String[] jack = {"小🃏", "大🃏"};

//            将牌组合在一堆
        for(String n : number){
            for(String cl : color){
                ph.put(i, (cl + n ) );   //将组合好的牌装到牌盒当中
                xp.add(i);
                i++;
            }
        }
        for(String sj : jack){          //添加大小王
            ph.put(i, sj);
            xp.add(i);
            i++;
        }

//        2、洗牌
////            2.1、取出牌盒当中的Key，存入洗牌器当中(可将这部分整合到创建牌堆当中)
//        Set<Integer> is = ph.keySet();  //利用增强For循环读取Key
//        for(Integer it : is){
//            xp.add(it);                 //装入洗牌器
//        }

//            2.2、洗牌 利用Collections类的shuffle(List<E> list)方法，打乱排序
        Collections.shuffle(xp);

       /* for(Integer o : xp){
            System.out.print(o + " ");
        }*/

//        3、发牌
            for(int j = 0; j < xp.size(); j++){
                if(j > (xp.size() - 4)){    //取三张底牌
                    dp1.add(xp.get(j));
                }else if((j % 3) == 0){     //发给A
//                    System.out.print("J:" + xp.get(j) + " ");
                    a1.add(xp.get(j));
                }else if((j % 3) == 1){     //发给B
                    b1.add(xp.get(j));
                }else if((j % 3) == 2){     //发给C
                    c1.add(xp.get(j));
                }else {
//                    do nothing
                }
            }

//        for(Integer x : a1){
//            System.out.print(x + " ");
//        }

//        4、排序
//            A
        a = PaiXu(a1, ph);

//        Set<Map.Entry<Integer, String>> es1 = a.entrySet();
//        for(Map.Entry<Integer, String> me1 : es1){
//            System.out.print(me1.getKey() + "+");
//            System.out.print(me1.getValue() + " ");
//
//        }

//            B
        b = PaiXu(b1, ph);
//            C
        c = PaiXu(c1, ph);
//           底牌
        dp = PaiXu(dp1, ph);


//        5、看牌
        LookPoker("A", a);
        LookPoker("B", b);
        LookPoker("C", c);
        LookPoker("底牌", dp);


    }


    //    排序
    public static HashMap<Integer, String> PaiXu(ArrayList<Integer> arrayList, HashMap<Integer, String> hashMap){
        HashMap<Integer, String> zc = new HashMap<>();  //暂存牌

//        创建TreeSet集合对象 排序
        TreeSet<Integer> px = new TreeSet<>(new Comparator<Integer>() { //利用匿名内部类，指定外部比较器
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 - o2);
            }
        });

//        for(Integer x : arrayList){
//            System.out.print(x + " ");
//        }

//        遍历发到手上的牌
        for(Integer a : arrayList){
//            将遍历出来的牌存到排序器当中，经行排序
            px.add(a);
        }

//        for(Integer x : px){
//            System.out.print(x + " ");
//        }

//        将排完序的牌进行对应整合
        zc = ZhengHe(px, hashMap);

//        返回整合好的牌
        return zc;
    }

//    整合
    public static HashMap<Integer, String> ZhengHe(TreeSet<Integer> treeSet, HashMap<Integer, String> hashMap){
        HashMap<Integer, String> zh = new HashMap<>();  //暂存牌

//        计数器
        int y = 0;

//        遍历排好序的牌
    for(Integer i : treeSet){
//        根据遍历出来的数据，去匹配牌盒里面对应的牌
        String s = hashMap.get(i);
//        System.out.println(s + " ");
//        将牌装入到暂存里面
        zh.put(y, s);
        y++;
    }

//        Set<Map.Entry<Integer, String>> es1 = zh.entrySet();
//        for(Map.Entry<Integer, String> me1 : es1){
//            System.out.print(me1.getKey() + "+");
//            System.out.print(me1.getValue() + " ");
//
//        }

//    返回整合好的牌
    return zh;
    }

//    看牌
    public static  void LookPoker(String s, HashMap<Integer, String> hashMap){
        System.out.println("用户" + s + "的牌是：");
//        遍历排好序的牌盒
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        for(Map.Entry<Integer, String> me : entries){
            System.out.print(me.getValue() + " ");
        }
        System.out.println();

    }
}
