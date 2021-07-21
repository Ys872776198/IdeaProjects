package BiLiExcisesCodes;

import java.util.Arrays;

/*
 * Arrays工具类的使用
 */

public class E6 {

	public static void main(String[] args) {
		int[] arr1 = new int[] {180, 20, 50, 100, 10, 80};
		int[] arr2 = new int[6];
		int[] arr3 = new int[] {180, 20, 50, 100, 10, 80};
		int[] arr4 = new int[] {180, 20, 50, 100, 10, 90};
		
//		1、数组的输出
//		System.out.println(Arrays.toString(arr1));
		
//		2、数组的排序（升序）
//		Arrays.sort(arr1);
//		System.out.println(Arrays.toString(arr1));
		
//		3、数组的查询
//		Arrays.sort(arr1);
//		System.out.println(Arrays.binarySearch(arr1, 50));
		
//		4、数组的比较
//		System.out.println(Arrays.equals(arr3, arr1));
//		System.out.println(Arrays.equals(arr3, arr4));
		
//		5、数组的复制
//		arr2 = Arrays.copyOf(arr1, 15);
//		System.out.println(Arrays.toString(arr2));
//		
//		int[] arr5 = Arrays.copyOfRange(arr1, 2, 4);
//		System.out.println(Arrays.toString(arr5));
		
//		6、数组的填充
		Arrays.fill(arr2, 10);
		System.out.println(Arrays.toString(arr2));
		
		Arrays.fill(arr2, 2, 4, 111);
		System.out.println(Arrays.toString(arr2));
		
	}
}
