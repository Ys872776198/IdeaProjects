package BiLiExcisesCodes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @Auther: YS
 * @Date: 2021/5/20
 * @Description: jdk1.8之后的常用时间类
 * @Version: 1.0
 */
public class E24 {

    public static void main(String[] args) {
////        1、完成实例化
////        方法1：New（）方法
////        LocalDate l1 = LocalDate.now();
////        System.out.println("当前日期：" + l1);
////        LocalTime l2 = LocalTime.now();
////        System.out.println("当前时间：" + l2);
////        LocalDateTime l3 = LocalDateTime.now();
////        System.out.println("当前日期+时间：" + l3);
//
////        方法2：of（）方法（设置指定时间）
////        LocalDate l4 = LocalDate.of(2020,5,24);
////        LocalTime l5 = LocalTime.of(13,50,20);
//        LocalDateTime l6 = LocalDateTime.of(2020,5,25,14,50,20);
////        System.out.println("当前日期：" + l4);
////        System.out.println("当前时间：" + l5);
////        System.out.println("当前日期+时间：" + l6);
//
////        演示以LocalDateTime类为例
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime localDateTime1 = LocalDateTime.now();
////        get方法
////        System.out.println(localDateTime.getYear());        //年
////        System.out.println(localDateTime.getMonth());       //月（英文）
////        System.out.println(localDateTime.getMonthValue());  //月（数值）
////        System.out.println(localDateTime.getDayOfMonth());  //一个月当中的几号
////        System.out.println(localDateTime.getDayOfWeek());   //星期几
////        System.out.println(localDateTime.getHour());        //几点
////        System.out.println(localDateTime.getMinute());      //几分
////        System.out.println(localDateTime.getSecond());      //几秒
//
////        没有set方法，而叫with方法
////        localDateTime1 = localDateTime.withMonth(8);            //将月份设置为8月，但是不会影响localDateTime的值，跟Calendar不同
////        System.out.println(localDateTime1);
////        System.out.println(localDateTime);
//
////        加操作（Puls方法）
////        localDateTime1 = localDateTime.plusMonths(4);
////        System.out.println(localDateTime1);
////        System.out.println(localDateTime);
//
////        减操作（minus方法）
//        localDateTime1 = localDateTime.minusMonths(2);
//        System.out.println(localDateTime1);
//        System.out.println(localDateTime);


//        DateTimeFormatter日期格式化类

//        方法1：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
//        DateTimeFormatter df1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//        df1能够帮助我们在String和LocalDateTime之间转换
//        LocalDateTime --》 String
//        先要有一个LocalDateTime对象,在调用format方法
//        LocalDateTime now = LocalDateTime.now();
//        String str1 = df1.format(now);
//        System.out.println(str1);

//        String --》 LocalDateTime
//        调用parse方法
//        TemporalAccessor parse = df1.parse("2021-05-24T22:58:26.357");
//        System.out.println(parse);

//        方法2：本地化相关格式。如：oflocalizedDateTime()
//        参数：FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT
//        DateTimeFormatter df2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
//        LocalDateTime --》 String
//        先要有一个LocalDateTime对象,在调用format方法
//        LocalDateTime now = LocalDateTime.now();
//        String str2 = df2.format(now);
//        System.out.println(str2);

//        String --》 LocalDateTime
//        调用parse方法。注意：在调用parse方法时，入参的格式要和oflocalizedDateTime()方法的入参格式保持一致
//        TemporalAccessor parse = df2.parse("2021年5月24日 下午11时08分45秒");
//        System.out.println(parse);

//        方法3：自定义格式。如：ofPattern("yyyy-MM-dd hh:mm:ss")        常用，重点
        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime --》 String
//        先要有一个LocalDateTime对象,在调用format方法
//        LocalDateTime now = LocalDateTime.now();
//        String str3 = df3.format(now);
//        System.out.println(str3);

//        String --》 LocalDateTime
//        调用parse方法。在调用parse方法时，入参的格式要和自定义的格式一致
        TemporalAccessor parse = df3.parse("2021-05-24");
        System.out.println(parse);


    }

}
