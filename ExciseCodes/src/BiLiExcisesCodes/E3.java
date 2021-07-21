package BiLiExcisesCodes;

import java.util.Scanner;

public class E3 {

	/*
	 * 猜字游戏
	 */
	public static void numGuess(int a)
	{
		Scanner sc = new Scanner(System.in);
		int num = (int)(Math.random() * 101);
		System.out.println("num:" + num);
		while(true)
		{
			if(a != num)
			{
				System.out.println("猜错了！");
				System.out.print("请重新输入：");
				a = sc.nextInt();
			}else if(a == num)
				{
					System.out.println("您中大奖了！");
					break;
				}else
				{
					/* do nothing */
				}
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入数据：");
		int a = sc.nextInt();
		E3.numGuess(a);
 	}
	
	
	
	
	
}
