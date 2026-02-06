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
		int[] nums = new int[]{2,2,3,3,3,4}; // 9
//		int[] nums = new int[]{3,4,2};  // 6
		Lg.infoClass(TAG + "1 is " + deleteAndEarn(nums));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "2 is " + deleteAndEarn02(nums));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "3 is " + deleteAndEarn03(nums));
		Lg.infoClass("  =  ");
	}

	public int deleteAndEarn(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
		int max = getMaxNum(nums);
		int[] all = getNewArray(nums, max);
		int[] dp = new int[max + 1];
		dp[1] = all[1];
		for (int i = 2; i <= max; ++i) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
		}
		return dp[max];
	}

	public int deleteAndEarn02(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
		int max = getMaxNum(nums);
		int[] all = getNewArray(nums, max);
		int pre = 0;
		int cur = all[1];
		int next = 0;
		for (int i = 2; i <= max; ++i) {
			next = Math.max(cur, pre + i * all[i]);
			pre = cur;
			cur = next;
		}
		return cur;
	}

	public int deleteAndEarn03(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
		int max = getMaxNum(nums);
		int[] all = getNewArray(nums, max);
		for (int i = 2; i <= max; ++i) {
			all[i] = Math.max(all[i-1], all[i-2] + i * all[i]);
		}
		return all[max];
	}


	private int getMaxNum(int[] nums){
		int max = nums[0];
		for (int num : nums) {
			max = Math.max(max, num);
		}
		return max;
	}
	private int[] getNewArray(int[] nums, int max){
		int[] all = new int[max + 1];
		for (int item : nums) {
			all[item] ++;
		}
		return all;
	}

}
