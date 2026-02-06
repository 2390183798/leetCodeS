package org.dodo.leetcode.t701_800.f741;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

import java.util.Arrays;

@ClassNum(740)
public class C740 implements ISolve {

//	给你一个整数数组 nums ，你可以对它进行一些操作。
//
//	每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
//
//	开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
//
//
//
//	示例 1：
//
//		输入：nums = [3,4,2]
//		输出：6
//		解释：
//		你可以执行下列步骤：
//			- 删除 4 获得 4 个点数，因此 3 也被删除。nums = [2]。
//			- 之后，删除 2 获得 2 个点数。nums = []。总共获得 6 个点数。
//
//	示例 2：
//
//		输入：nums = [2,2,3,3,3,4]
//		输出：9
//		解释：
//		你可以执行下列步骤：
//			- 删除 3 获得 3 个点数。所有的 2 和 4 也被删除。nums = [3,3]。
//			- 之后，再次删除 3 获得 3 个点数。nums = [3]。
//			- 再次删除 3 获得 3 个点数。nums = []。总共获得 9 个点数。
//
//
//	提示：
//
//			1 <= nums.length <= 2 * 104
//			1 <= nums[i] <= 104


	String TAG = "删除并获得点数";

	@Override
	public void doSth() {
		int[] nums = new int[]{2,2,3,3,3,4};
//		int[] nums = new int[]{3,3,3,3,3,3};
		Lg.infoClass(TAG + "1 is " + deleteAndEarn(nums));
		Lg.infoClass("  =  ");
	}

	public int deleteAndEarn(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
		int max = getMaxNum(nums);
//      构造一个新的数组all，举例，如果 all[8] 是 3, 说明 nums 数组里等于8 的元素有3个
		int[] all = new int[max + 1];
		for (int item : nums) {
			all[item] ++;
		}
		int[] dp = new int[max + 1];
		dp[1] = all[1];
		for (int i = 2; i <= max; ++i) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
		}
		return dp[max];
	}


	private int getMaxNum(int[] nums){
		int max = nums[0];
		for (int num : nums) {
			max = Math.max(max, num);
		}
		return max;
	}

}
