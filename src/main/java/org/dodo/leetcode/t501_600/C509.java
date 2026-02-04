package org.dodo.leetcode.t501_600;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

@ClassNum(509)
public class C509 implements ISolve {

	@Override
	public void doSth() {
//		int num = fib(4);
		int num = fib02(4);
		Lg.info("fib is " + num);
	}


	public int fib(int n) {
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		int end1 = 0;
		int end2 = 1;
		int tempSum = 0;
		for(int i=0; i<n-1; i++){
			tempSum = end1 + end2;
			end1 = end2;
			end2 = tempSum;
		}
		return end2;
	}

	public int fib02(int n) {
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		int[] arr = new int[n];
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2; i<n; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n-1] + arr[n-2];
	}



}
