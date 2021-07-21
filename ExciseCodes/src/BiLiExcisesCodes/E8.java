package BiLiExcisesCodes;

import java.util.Arrays;

/*
 * 数组的选择排序
 */
public class E8 {
	public static void main(String[] args) {
		int[] arr = {180, 20, 50, 100, 10, 80};
		
		int temp;
		
		for(int i = 0; i < arr.length - 1; i++)
		{
			int min = i;
			for(int j = (i + 1); j < arr.length; j++)
			{
				if(arr[j] < arr[min])
				{
					min = j;
				}
			}
			if(min != i)
			{
				temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		System.out.print(Arrays.toString(arr));
	}
	
	
	
}
