package org.dodo.leetcode.t701_800;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.Lg;

public class St741 implements ISolve {

	@Override
	public void doSth() {
		int[] cost = new int[]{10,1,10,1,10};
        minCostClimbingStairs(cost);
	}

	public void minCostClimbingStairs(int[] cost) {
		int num = solve01(cost);
		Lg.info("miniCost is " + num);
	}


	public int solve01(int[] cost) {
		int length = cost.length;
		// 用 数组记录 对于 index的 最小和
		int[] mini = new int[length];
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


	public int solve02(int[] cost) {
		int length = cost.length;
		int[] mini = new int[length];
		mini[0] = 0;
		mini[1] = Math.min(cost[0], cost[1]);
		for(int i=2; i<length; i++){
			mini[i] = Math.min(mini[i-1] + cost[i], mini[i-2] + cost[i-1]);
		}
		return mini[length-1];
	}



}
