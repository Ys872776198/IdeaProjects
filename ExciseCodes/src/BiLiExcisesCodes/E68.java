package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/7/29
 * @Description: 反射
 * @Version: 1.0
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射：Java反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意属性和方法；
 *      这种动态获取信息以及动态调用对象方法的功能被称为Java语言的反射机制。（强调的是运行状态，动态调用数据）
 */
//案例：美团购物支付
public class E68 {
    public static void main(String[] args) {
//        使用多态来处理选择银行卡支付的问题
//        /**
//         * 利用多态解决问题能很好提高代码的拓展性，但不是最好的。
//         * 根据这个案例我们可以看到，每增加或者删除一个支付方式，我们不仅要增加或者删除一个新的类，还要增加或是删除对应的判断。
//         * 由此看来，代码的拓展性还没有达到最好。
//         * 因此，我们可以利用反射来最优化拓展性
//         */
//        String s = "银行卡";                    //此出模拟用户选择支付方式，反馈给后台的信息
//        if("微信".equals(s)){
//            PayMode(new WeiXin());           //此处利用多态完成设计
//        }else if("支付宝".equals(s)){
//            PayMode(new ZhiFuBao());         //此处利用多态完成设计
//        }else if("银行卡".equals(s)){
//            PayMode(new BankCard());         //此处利用多态完成设计
//        }

//        利用反射来处理这个问题
        String s = "BiLiExcisesCodes.WeiXin";                    //此出模拟用户选择支付方式，反馈给后台的信息,
                                                                   //现在这个字符串就是选择的支付方式的全限定路径（包名.类名）

//        下面的方法就是利用反射了
//        下面的代码基本上不用再动了，后台只需要接收对应的全限定路径就行了，再删除或者增加支付方式，只需要删除或者添加对应的类
        try {
            Class ac = Class.forName(s);                //通过调用forName方法，将指定的路径编译为.class文件，并将这个文件封装成Class类
            Object o = ac.newInstance();                //这个Class类里面包含了指定路径的所有数据。这一步就是实例化指定文件的对象等于 new WeiXin();
            Method mt = ac.getMethod("Pay");      //获取指定路径下的具体方法，将这个方法封装成Method对象。
            mt.invoke(o);                               //调用指定路径下的具体方法，这一步等于 (new WeiXin()).Pay; 即有实例化的对象调用这个方法。
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

//    public static void PayMode(MeiTuan m){
//        m.Pay();
//    }
}
