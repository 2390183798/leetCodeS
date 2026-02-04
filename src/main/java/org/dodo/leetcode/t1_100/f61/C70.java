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


	@Override
	public void doSth() {
		int n = 5;
		int num = climbStairs(n);
		int num02 = climbStairs02(n);
		Lg.info("爬梯子1 n"+ n +" is " + num);
		Lg.info("  =  ");
		Lg.info("爬梯子2 n"+ n +" is " + num02);
	}

	public int climbStairs(int n) {
		int end1 = 1;
		int end2 = 1;
		int tempSum = 0;
		for(int i=0; i<n-1; i++){
			tempSum = end1 + end2;
			end1 = end2;
			end2 = tempSum;
		}
		return end2;
	}

	public int climbStairs02(int n) {
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



}
