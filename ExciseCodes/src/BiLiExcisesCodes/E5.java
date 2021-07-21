package BiLiExcisesCodes;

/*
 * main方法的使用
 */

public class E5 {
	
//	public static void add(int a ,int...arr)
	public static void add(int...arr)
	{
		System.out.println("数组的长度：" + arr.length);
		
		int[] arr1 = new int[arr.length];
		
		System.out.println("OK");
		
		for(int b : arr)
		{
			
		}
	}
	
	public static void main(String[] args) {
//		add(10, 20, 30, 40, 50, 60, 70);
//		add(new int[] {0, 10, 20, 30, 40, 50, 60, 70});

//      遍历args数组
		for(String s : args) 
		{
			System.out.println(s);
		}
		
		System.out.println(args.length);
	}
}
