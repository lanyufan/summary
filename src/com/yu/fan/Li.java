package com.yu.fan;

/**
 * 案例
 */
public class Li {

	/**
	 * 鸡兔同笼
	 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
	 */
	public void test01(){
		
		//前两个月
		System.out.println("第1个月的兔子对数：1");
		System.out.println("第2个月的兔子对数：1");
		
		//第一个月
		int f1 = 1;
		//第二个月
		int f2 = 1;
		//
		int f;
		//月份
		int M = 12;								
		
		for (int i = 3; i <= M; i++/*判断从第3个月开始*/) {
			//
			f = f2;
			//递归（自调）
			f2 = f1 + f2;
			//
			f1 = f;
			
			System.out.println("第"+i+"个月的兔子对数："+f2);
		}
	}
}
