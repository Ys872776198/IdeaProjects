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
 * @Date: 2021/5/15
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class E23 {
    public static void main(String[] args) {
       Time();
    }

    public static void Time()  {
        while(true)
        {
//            设置一个循环计数，让日期以7为基数循环
            int count = 0;

//            获取输入的时间
            Scanner sc = new Scanner(System.in);
//            设置时间格式
//            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
//            System.out.println("请输入时间(默认格式为yyyy/mm/dd,不支持其他格式)：");
            System.out.println("请输入时间(默认格式为yyyy-mm-dd,不支持其他格式)：");
            String s1 = sc.nextLine();
//            java.util.Date ud1 = df.parse(s1);
//            Date sd1 = (Date) ud1;

//            将String --> Calendar
//            Date sd1 = Date.valueOf("2021-5-16");
            Date sd1 = Date.valueOf(s1);
            Calendar cal = new GregorianCalendar();
            cal.setTime(sd1);

//            获取当天日期
            int newday = cal.get(Calendar.DATE);

//            获取当前月份的总天数
            int sumday = cal.getActualMaximum(Calendar.DATE);
//            System.out.println(sumday);

//            获取当月1号的信息
            cal.set(Calendar.DATE, 1);
            int firstday = cal.get(Calendar.DAY_OF_WEEK);
//            System.out.println("1号:" + firstday);

//            设置日历格式
            System.out.println("日\t一\t二\t三\t四\t五\t六");

//            获取1号星期信息时，将1号放入对应的位置
            for(int a = 1; a < firstday; a++)
            {
                System.out.print("\t");
                count++;
            }

//            设置日期循环
            for(int i = 1; i <= sumday; i++)
            {
//                在指定日期下增加*
                if(newday == i)
                {
                    System.out.print(i + "*" + "\t");
                }else
                {
                    System.out.print(i + "\t");
                }

//                分行
                count++;
                if((count % 7) == 0)
                {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}
