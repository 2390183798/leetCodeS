package org.dodo.leetcode.t501_600.f501;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

@ClassNum(509)
public class C509 implements ISolve {


//	斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
//	该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
//	也就是：
//
//		F(0) = 0，F(1) = 1
//		F(n) = F(n - 1) + F(n - 2)，其中 n > 1
//	给定 n ，请计算 F(n) 。
//
//
//
//	示例 1：
//
//		输入：n = 2
//		输出：1
//		解释：F(2) = F(1) + F(0) = 1 + 0 = 1
//
//	示例 2：
//
//		输入：n = 3
//		输出：2
//		解释：F(3) = F(2) + F(1) = 1 + 1 = 2
//
//	示例 3：
//
//		输入：n = 4
//		输出：3
//		解释：F(4) = F(3) + F(2) = 2 + 1 = 3
//
//
//	提示：
//
//			0 <= n <= 30




	@Override
	public void doSth() {
		int n = 4;
//		int num = fib(n);
		int num = fib02(n);
		Lg.info("斐波那契数列 n"+ n +" is " + num);
	}


	public int fib(int n) {
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		int end1 = 0;
		int end2 = 1;
		int tempSum = 0;
		for(int i=0; i<n-1; i++){
			tempSum = end1 + end2;
			end1 = end2;
			end2 = tempSum;
		}
		return end2;
	}

	public int fib02(int n) {
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2; i<=n; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}



}
