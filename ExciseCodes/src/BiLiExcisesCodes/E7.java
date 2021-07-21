package BiLiExcisesCodes;

import java.util.Arrays;

/*
 * System工具类的使用
 */

public class E7 {
	public static void main(String[] args) {
//		1、数组的复制
		int[] arr1 = new int[] {1,2,3,4,5,6};
		int[] arr2 = new int[] {0,0,0,0,0,0};
		System.arraycopy(arr1, 2, arr2, 3, 1);
		System.out.println(Arrays.toString(arr2));
	}
	
}
