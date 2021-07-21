package BiLiExcisesCodes;

/**
 * @Auther: YS
 * @Date: 2021/6/19
 * @Description: 泛型（2）：泛型方法
 * @Version: 1.0
 */



public class E28<E> {
//    1：泛型方法:不是带泛型的方法就是泛型方法。
//    泛型方法要求：这个方法的泛型参数类型与当前类的泛型参数类型无关
//    （泛型方法对应的那个泛型参数类型和当前所在类是否是泛型类，泛型参数类型是什么，都无关）

//    2：泛型方法在定义的时候，前面要加上<T>。原因：如果不加的话，会把T当作一种数据类型，然而代码中没有T类型那么就会报错
//    如： public <T> void b(T t){
//    }

//    3：T的类型在调用方法时确定（输入参数为Object类型，意味着泛型方法可以接受与当前类一致或者不一致的参数，入参为引用数据类型）

//    4：泛型方法可以被static修饰。原因：因为泛型方法的泛型参数类型与当前类无关，
//    具体的泛型在被调用时确定，因此该方法可以先于对象存在
//    static具体位置如：    public static <T> void b(T t){


//        不是泛型方法
    public  void a (E e){
        System.out.println("这不是泛型方法");
    }

//        这是泛型方法
//    public static <T> void b(T t){
    public <T> void b(T t){
        System.out.println("这是泛型方法");
    }


}

class E28Main{

    public static void main(String[] args) {
        E28<Character> e1 = new E28();
        e1.b(19);
        e1.b("abs");
//        e1.b(new Character[]{'c', 'w', 'w'});
//        e1.b(new Integer[]{1, 2,3});
//        e1.b(new String[]{"a", "b", "c"});
        e1.a('b');
    }
}