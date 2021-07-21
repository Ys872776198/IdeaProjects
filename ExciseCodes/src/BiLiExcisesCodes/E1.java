package BiLiExcisesCodes;

import java.util.Scanner;

public class E1 {
	public static void main(String arge[]) {
		int j;
		Scanner num = new Scanner(System.in);
		System.out.println("请输入数据：");
		int x = num.nextInt();
		for(int i = 1; i <= x; i++ ) {
			for(j = 1; j <= (x-i); j++) {
				System.out.print(" ");
			}
			for(int z = 1; z < (2 * i); z++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
