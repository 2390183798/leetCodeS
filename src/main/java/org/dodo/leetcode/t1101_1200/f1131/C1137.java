package org.dodo.leetcode.t1101_1200.f1131;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

@ClassNum(1137)
public class C1137 implements ISolve {

	@Override
	public void doSth() {
		int n = 25;
//		int num = tribonacci(n);
		int num = tribonacci02(n);
		Lg.info("第 N 个泰波那契数 n"+ n +" is " + num);
	}

	public int tribonacci(int n) {
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

}
