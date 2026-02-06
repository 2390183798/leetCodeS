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


//	思考过程：
//	1层:
//		sum1 = 0
//		sum1Done = sum1 + cost[1]
//	2层:
//		sum2 = Math.min(cost[1], cost[0])
//		sum2Done = sum2 + cost[2]
//
//	3层:
//		sum3 = Math.min(sum2Done, sum1Done)
//		sum3Done = sum3 + cost[3]
//
//	4层:
//		sum4 = Math.min(sum2Done, sum1Done)

	String TAG = "使用最小花费爬楼梯";

	@Override
	public void doSth() {
//		int[] cost = new int[]{10,15};	// 答案 10
//		int[] cost = new int[]{10,15,20};	// 答案 15
		int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};	// 答案 6

		Lg.infoClass(TAG + "1 is " + minCostClimbingStairs(cost));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "2 is " + minCostClimbingStairs02(cost));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "3 is " + minCostClimbingStairs03(cost));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "4 is " + minCostClimbingStairs04(cost));
	}

	public int minCostClimbingStairs(int[] cost) {
		int length = cost.length;
		int[] mini = new int[length];
		// 用 数组记录 对于 index的 最小和
		mini[0] = 0;
		mini[1] = Math.min(cost[1], cost[0]);
		for(int i=2; i<length; i++){
			// 对应 index为 i的最小和为：  下列2个中的最小值
			//			i-1 最小和 + cost[i]
			//			i-2 最小和 + cost[i-1]
			mini[i] = Math.min(mini[i-1] + cost[i], mini[i-2] + cost[i-1]);
		}
		return mini[length-1];
	}


	public int minCostClimbingStairs02(int[] cost) {
		int length = cost.length;
		// 用 数组记录 对于 index的 最小和
		int sumEnd0 = 0;	// 最前面的， 现在是 index是0的最低花费是0 （直接爬2台阶）
		int sumEnd1 = Math.min(cost[1], cost[0]); // 倒数第2的， 现在是 index是1的最低花费， 前面2个值中最小的
		for(int i=2; i<length; i++){
			// 第1轮， 也就是 index是2个时候
			int temp0 = sumEnd0 + cost[i-1];	// 如果前面是2台阶上来的，当前花费需要加上 cost[i-1] (第1轮，是cost1)
			int temp1 = sumEnd1 + cost[i];		// 如果前面是2台阶上来的，当前花费需要加上 cost[i-1] (第1轮，是cost1)
			sumEnd0 =  sumEnd1;
			sumEnd1 = Math.min(temp1 , temp0);
		}
		return sumEnd1;
	}


	public int minCostClimbingStairs03(int[] cost){
		int sumEnd0 = 0;
		int sumEnd1 = Math.min(cost[1], cost[0]);
		for(int i=2; i<cost.length; i++){
			int next = Math.min(sumEnd1 + cost[i], sumEnd0 + cost[i-1]);
			sumEnd0 = sumEnd1;
			sumEnd1 = next;
		}
		return sumEnd1;
	}


	public int minCostClimbingStairs04(int[] cost){
		int n = cost.length;
		for(int i=2; i<n; i++){
			cost[i] += Math.min(cost[i-1], cost[i-2]);
		}
		return Math.min(cost[n-1], cost[n-2]);
	}



}
