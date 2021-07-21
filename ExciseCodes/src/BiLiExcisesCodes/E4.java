package BiLiExcisesCodes;

import java.util.Scanner;

/*
 * 数组的使用
 */

public class E4 {

	public static int arrNum(int[] arr)
	{
		int numMax = 0;
		int numMin = 0;
		
		for(int a = 0; a < arr.length; a++)
		{
			if(arr[a] > numMax)
			{
				numMax = arr[a];
			}else
			{
				/* do nothing */
			}
			
			if(arr[a] < numMin)
			{
				numMin = arr[a];
			}else
			{
				/* do nothing */
			}		
		}
		System.out.println("最小值：" + numMin);
		return numMax;
	}
	
	public static void main(String[]  args)
	{
////		数组的声明，赋值与使用
//		int[] arr1;
//		int[] arr2 = null;
//		int[] arr3 = new int[6];
//		int[] arr4 = { 0, 1, 2, 3 };
//		int[] arr5 = new int[]{0, 1, 2, 3, 4};
//
////
//		arr1 = new int[4];
//		
//		
////		数组的赋值
//		for(int i = 0; i < 4; i++)
//		{
//			arr4[i] = i;
//		}
//		
//		
////		数组的使用
//		for(int a = 0; a < 4; a++)
//		{
//			System.out.println("数组的第" + a + "个数：" + arr4[a]);
//		}
//		
//		System.out.println("数组的长度：" + arr3.length);

	
		
		int[] arr1 = new int[6];
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < arr1.length; i++)
		{
			System.out.println("请输入数组的第" + i + "个数：");
			arr1[i] = sc.nextInt(); 
		}
		 int max = arrNum(arr1);
		 
		 System.out.println("最大值：" + max);
		
	}	
}
