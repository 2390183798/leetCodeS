package org.dodo.leetcode.t1_100.f61;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

@ClassNum(70)
public class C70 implements ISolve {

	@Override
	public void doSth() {
		int n = 5;
//		int num = climbStairs(n);
		int num = climbStairs02(n);
		Lg.info("爬梯子 n"+ n +" is " + num);
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
//		return arr[n-1];
	}



}
