package BiLIExciseTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @Auther: YS
 * @Date: 2022/3/31 22:31
 * @Description: 统计字符串中字母出现的次数(测试数据：abcddbcaaabcd)
 * @Version: 1.0
 */
public class Test_HashMap {

    public static void main(String[] args) {
//        获取一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s = sc.nextLine();

//        创建HashMap集合对象，Key：Character, value: Integer
        HashMap<Character, Integer> hs1 = new HashMap<>();

//        创建一个字符串拼接对象
        StringBuilder sb = new StringBuilder();

//        获取字符串的每个字符，与HashMap集合进行查找，返回值为null，则直接存入，否则 +1 存入
        for(int i = 0; i < s.length(); i++ ){
//            System.out.println(s.length());
            char c = s.charAt(i);   /*获取字符串字符*/
//            System.out.println(c);
            if(hs1.containsKey(c)){   /*判断对于的字符是否存在*/
                Integer i1 = hs1.get(c);
                i1 += 1;                /*如果字符已存在，那么次数加一，存入集合当中*/
                hs1.put(c, i1);
            }else {
                hs1.put(c, 1);
            }
        }

//        输出结果1：entry
//        Set<Map.Entry<Character, Integer>> es = hs1.entrySet();
//        for(Map.Entry<Character, Integer> me : es){
//            sb.append(me.getKey()).append("(").append(me.getValue()).append(")");
////            System.out.println(me.getKey() + "(" + me.getValue() + ")");
//        }

//        输出结果2：增强For循环
        Set<Character> cs = hs1.keySet();
        for(Character cr : cs){
            sb.append(cr).append("(").append(hs1.get(cr)).append(")");
//            System.out.println(cr + "(" + hs1.get(cr) + ")");
        }

        s = sb.toString();
        System.out.println(s);



    }

}
