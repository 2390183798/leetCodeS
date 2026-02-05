package org.dodo.leetcode.t101_200.f191;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

@ClassNum(198)
public class C198 implements ISolve {


//	你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
//	影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
//	如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
//	给定一个代表每个房屋存放金额的非负整数数组，
//	计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//
//
//	示例 1：
//
//		输入：[1,2,3,1]
//		输出：4
//		解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//		偷窃到的最高金额 = 1 + 3 = 4 。
//
//	示例 2：
//
//		输入：[2,7,9,3,1]
//		输出：12
//		解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//		偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//
//
//	提示：
//
//			1 <= nums.length <= 100
//			0 <= nums[i] <= 400

//	参考： https://leetcode.cn/problems/house-robber/solutions/138131/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap/?envType=study-plan-v2&envId=dynamic-programming

//	思路：
//	f(k) 最大， 就看。f(k-2) + num[k-1]  和 f(k-1) 谁大
//
//	当 n=0，  f(0) = 0
//	当 n=1，  f(1) = num[0]
//	当 n=2，  f(2) = max( f(0) + num[1],  f(1) )
//	当 n=3，  f(3) = max( f(1) + num[2],  f(2) )
//


	String TAG = "打家劫舍";

	@Override
	public void doSth() {
//		int[] data = new int[]{1,2,3,1};	// 4
		int[] data = new int[]{2,7,9,3,1};	// 12
		Lg.info(TAG + "1 is " + rob(data));
		Lg.info("  =  ");
		Lg.info(TAG + "2 is " + rob02(data));
//		Lg.info("  =  ");
//		Lg.info(TAG + "3 is " + rob03(data));
	}

	public int rob(int[] nums) {
		int n = nums.length;
		if(n == 0){
			return 0;
		}

		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = nums[0];
		for(int i=2; i<=n; i++){
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
		}
		return dp[n];
	}


	public int rob02(int[] nums) {
		int n = nums.length;
		if(n == 0){
			return 0;
		}

		int pre = 0;
		int cur = 0;
		for(int i=2; i<n; i++){
			int next = Math.max(cur, pre+nums[i]);
			cur = pre;
			pre = next;
		}
		return cur;
	}


	public int rob03(int[] nums) {
		int n = nums.length;
		if(n == 0){
			return 0;
		}

		for(int i=2; i<n; i++){
			nums[i] += Math.max(nums[i-1], nums[i-2]);
		}
		return Math.max(nums[n-1], nums[n-2]);
	}

}
