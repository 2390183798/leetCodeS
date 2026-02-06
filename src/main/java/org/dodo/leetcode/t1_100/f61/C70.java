package org.dodo.leetcode.t1_100.f61;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

@ClassNum(70)
public class C70 implements ISolve {

//	假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//	每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//
//
//	示例 1：
//
//		输入：n = 2
//		输出：2
//		解释：有两种方法可以爬到楼顶。
//			1. 1 阶 + 1 阶
//			2. 2 阶
//
//
//	示例 2：
//		输入：n = 3
//		输出：3
//		解释：有三种方法可以爬到楼顶。
//			1. 1 阶 + 1 阶 + 1 阶
//			2. 1 阶 + 2 阶
//			3. 2 阶 + 1 阶
//
//
//	提示：
//
//			1 <= n <= 45
//

	String TAG = "爬梯子";

	@Override
	public void doSth() {
//		int n = 5;
//		int n = 2;
//		int n = 3;
//		int n = 4;
//		int n = 5;
		int n = 45;
		Lg.infoClass(TAG + "1 is " + climbStairs(n));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "2 is " + climbStairs02(n));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "3 is " + climbStairs03(n));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "4 is " + climbStairs04(n));
	}

	public int climbStairs(int n) {
		if(n == 1){
			return 1;
		}
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2; i<n; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n-1] + arr[n-2];
	}

	public int climbStairs02(int n) {
		if(n == 1){
			return 1;
		}
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2; i<=n; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}

	public int climbStairs03(int n) {
		int end1 = 1;
		int end2 = 1;
		int tempSum = 0;
		for(int i=2; i<=n; i++){
			tempSum = end1 + end2;
			end1 = end2;
			end2 = tempSum;
		}
		return tempSum;
	}


	public int climbStairs04(int n) {
		if(n <= 3){
			return n;
		}
		double num01 = Math.pow((1 + Math.sqrt(5)) / 2, n+1);
		double num02 = Math.pow((1 - Math.sqrt(5)) / 2, n+1);
		return (int)Math.round((num01 - num02)/ Math.sqrt(5));
	}

}
