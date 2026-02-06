package org.dodo.leetcode.t1101_1200.f1131;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

@ClassNum(1137)
public class C1137 implements ISolve {

//	泰波那契序列 Tn 定义如下：
//
//	T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
//	给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
//
//
//
//	示例 1：
//
//		输入：n = 4
//		输出：4
//		解释：
//		T_3 = 0 + 1 + 1 = 2
//		T_4 = 1 + 1 + 2 = 4
//
//	示例 2：
//
//		输入：n = 25
//		输出：1389537
//
//
//	提示：
//
//			0 <= n <= 37
//			答案保证是一个 32 位整数，即 answer <= 2^31 - 1。


	@Override
	public void doSth() {
		int n = 25;
		Lg.infoClass("第 N 个泰波那契数 n"+ n +" is " + tribonacci(n));
		Lg.infoClass("  =  ");
		Lg.infoClass("第 N 个泰波那契数2 n"+ n +" is " + tribonacci02(n));
		Lg.infoClass("  =  ");
		Lg.infoClass("第 N 个泰波那契数3 n"+ n +" is " + tribonacci03(n));
	}

	public int tribonacci(int n) {
		if(n==0){
			return 0;
		}
		if(n==1 || n==2){
			return 1;
		}
		int[] arr = new int[n];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		for(int i=3; i<n; i++){
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		return arr[n-1] + arr[n-2] + arr[n-3];
	}


	public int tribonacci02(int n) {
		if(n==0){
			return 0;
		}
		if(n==1 || n==2){
			return 1;
		}
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		for(int i=3; i<=n; i++){
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		return arr[n];
	}


	public int tribonacci03(int n) {
		if(n==0){
			return 0;
		}
		if(n == 1 || n == 2){
			return 1;
		}
		int end0 = 0;
		int end1 = 1;
		int end2 = 1;
		int tempSum =0;

		for(int i=1; i<n-1; i++){
			tempSum = end0 + end1 + end2;
			end0 = end1;
			end1 = end2;
			end2 = tempSum;
		}
		return end2;
	}

}
