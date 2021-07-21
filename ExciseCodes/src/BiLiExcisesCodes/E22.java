package BiLiExcisesCodes;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @Auther: YS
 * @Date: 2021/5/14
 * @Description: 常用时间类
 * @Version: 1.0
 */
public class E22 {
    public static void main(String[] args) {
//        util --> sql
//        1、利用构造器
//        java.util.Date ud1 = new java.util.Date();
//        Date sd2 = new Date(ud1.getTime());
//        System.out.println(ud1.getTime());
//        System.out.println(sd2);
//        2、向下转型
//        Date sd = (Date) ud1;

//        java.sql.Date和java.util.Date区别：
//        前者表示范围是：年月日
//        后者表示范围是：年月日 时分秒

//        java.sql.Date和java.util.Date联系：
//        java.sql.Date(子类) extends java.util.Date(父类)



//        while(true)
//        {
//            try{
//                    Scanner sc = new Scanner(System.in);
//                    System.out.println("请输入时间：");   //默认格式为yyyy-mm-dd,不支持其他格式
//                    String s1 = sc.nextLine();

////                    String --> java.util.Date分两步：
////                      1、String --> java.sql.Date
//                    Date d1 = Date.valueOf(s1);
////                      2、java.sql.Date --> java.util.Date(子类到父类，向上转型，多态应用)
//                    java.util.Date d2 = d1;
//                    System.out.println("时间：" + d2.toString());
//                }catch (Exception ex){
//                    ex.printStackTrace();
//            }
//        }

//        为了灵活设置时间的格式，引入：DataFormat类，DataFormat类为抽象类，不能声明对象，只能向上转型，调用子类SimpleDateFormat
//            设置格式化的标准
//        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        String --> Date
//        try {
//            Date d = df.parse("1010/10/10 18:18:18");
//            System.out.println("时间：" + d.toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        Date ——> String
//       String s = df.format(new Date());
//       System.out.println("时间：" + s.toString() );
//       Date d = new Date();
//       System.out.println("当前时间:" + d.toString());

//        日历类：Calendar类。该类为抽象类，通过调用子类GregorianCalendar来声明对象，或者调用getInstance方法返回一个Calendar类的数据
        Calendar cal = new GregorianCalendar();
//        Calendar c1 = Calendar.getInstance();
//        System.out.println(cal);

//        Calendar类常用方法：
//        cal.set(Calendar.YEAR, 2020);
//        cal.set(Calendar.MARCH, 3);
//        cal.set(Calendar.DATE, 18);
//        System.out.println(cal.get(Calendar.YEAR));
//        System.out.println(cal.get(Calendar.MARCH));
//        System.out.println(cal.get(Calendar.DATE));
//        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal.getActualMaximum(Calendar.DATE));
        System.out.println(cal.getActualMinimum(Calendar.DATE));

//        System.out.println(cal);
//        String --> Calendar
//            1、String --> java.sql.Date
//        Date d3 = Date.valueOf("1010-10-10");
//            2、java.sql.Date --> Calendar
//        cal.setTime(new java.util.Date());
//        cal.setTime(d3);

    }
}
