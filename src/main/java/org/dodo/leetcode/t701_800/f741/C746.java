package org.dodo.leetcode.t701_800.f741;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

@ClassNum(746)
public class C746 implements ISolve {

//	给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
//	一旦你支付此费用，即可选择向上爬一个或者两个台阶。
//
//	你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
//
//	请你计算并返回达到楼梯顶部的最低花费。
//
//
//
//	示例 1：
//
//		输入：cost = [10,15,20]
//		输出：15
//		解释：你将从下标为 1 的台阶开始。
//				- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
//		总花费为 15 。
//
//	示例 2：
//
//		输入：cost = [1,100,1,1,1,100,1,1,100,1]
//		输出：6
//
//	解释：你将从下标为 0 的台阶开始。
//		- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//		- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//		- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//		- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//		- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//		- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
//		总花费为 6 。
//
//
//	提示：
//
//			2 <= cost.length <= 1000
//			0 <= cost[i] <= 999



	@Override
	public void doSth() {
		int[] cost = new int[]{10,15,20};	// 答案 15
//		int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};	// 答案 6
		int num = solve01(cost);
		int num02 = solve02(cost);
		Lg.info("使用最小花费爬楼梯1 is " + num);
		Lg.info("  =  ");
		Lg.info("使用最小花费爬楼梯2 is " + num02);
	}

	public void minCostClimbingStairs(int[] cost) {
		int num = solve01(cost);
		Lg.info("miniCost is " + num);
	}


	public int solve01(int[] cost) {
		int length = cost.length;
		// 用 数组记录 对于 index的 最小和
		int sunEnd0 = 0;
		int sunEnd1 = Math.min(cost[0], cost[1]);
		int tempSum = 0;
		for(int i=2; i<length; i++){
			// 对应 index为 i的最小和为：  下列2个中的最小值
			//			i-1 最小和 + cost[i]
			//			i-2 最小和 + cost[i-1]
			sunEnd0 += cost[i-1];
			sunEnd1 += cost[i];
			tempSum = Math.min(sunEnd1 , sunEnd0);
		}
		return tempSum;
	}


	public int solve02(int[] cost) {
		int length = cost.length;
		int[] mini = new int[length];
		// 用 数组记录 对于 index的 最小和
		mini[0] = 0;
		mini[1] = Math.min(cost[0], cost[1]);
		for(int i=2; i<length; i++){
			// 对应 index为 i的最小和为：  下列2个中的最小值
			//			i-1 最小和 + cost[i]
			//			i-2 最小和 + cost[i-1]
			mini[i] = Math.min(mini[i-1] + cost[i], mini[i-2] + cost[i-1]);
		}
		return mini[length-1];
	}



}
