package org.dodo.leetcode.t1_100.f61;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

import java.util.Arrays;

@ClassNum(62)
public class C62 implements ISolve {

//	一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
//	问总共有多少条不同的路径？
//
//
//
//	示例 1：
//
//		输入：m = 3, n = 7
//		输出：28
//
//	示例 2：
//
//		输入：m = 3, n = 2
//		输出：3
//		解释：
//		从左上角开始，总共有 3 条路径可以到达右下角。
//			1. 向右 -> 向下 -> 向下
//			2. 向下 -> 向下 -> 向右
//			3. 向下 -> 向右 -> 向下
//
//	示例 3：
//
//		输入：m = 7, n = 3
//		输出：28
//
//	示例 4：
//
//		输入：m = 3, n = 3
//		输出：6
//
//
//	提示：
//		1 <= m, n <= 100
//		题目数据保证答案小于等于 2 * 109

	String TAG = "不同路径";

	@Override
	public void doSth() {
		int m = 3, n = 7;   // 28
//		int m = 3, n = 2;   // 3
		Lg.infoClass(TAG +"1 is " + uniquePaths(m, n));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "2 is " + uniquePaths02(m, n));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "3 is " + uniquePaths03(m, n));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "4 is " + uniquePaths04(m, n));
	}

	public int uniquePaths(int m, int n) {
//		int[][] dp = initArr(m,n);
		int[][] dp = new int[m][n];
		for(int i=0; i< Math.max(m, n); i++){
			if(i<m){
				dp[i][0] = 1;
			}
			if(i<n){
				dp[0][i] = 1;
			}
		}
		//两个for循环推导，对于(i,j)来说，只能由上方或者左方转移过来
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	public int uniquePaths02(int m, int n) {
		int[][] dp=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i*j==0){
					dp[i][j]=1;
				} else {
					dp[i][j]=dp[i-1][j]+dp[i][j-1];
				}
			}
		}
		return dp[m-1][n-1];
	}

	public int uniquePaths03(int m, int n) {
		int[] dp = new int[m];
		Arrays.fill(dp, 1);
		for (int j = 1; j < n; j++)
			for (int i = 1; i < m; i++)
				dp[i] += dp[i - 1];
		return dp[m - 1];
	}

	public int uniquePaths04(int m, int n) {
		int[] dp = new int[m];
		for (int j = 0; j < n; j++){
			for (int i = 0; i < m; i++){
				if(i==0){
					dp[i] = 1;
				} else {
					dp[i] += dp[i - 1];
				}
			}
		}
		return dp[m - 1];
	}


	public int[][] initArr(int m, int n){
		int[][] dp = new int[m][n];
//		//第一行都赋予 1
//		for(int i = 0; i < m; ++i) {
//			dp[i][0] = 1;
//		}
//		//第一列都赋予 1
//		for(int j = 0; j < n; ++j) {
//			dp[0][j] = 1;
//		}
		for(int i=0; i< Math.max(m, n); i++){
			if(i<m){
				dp[i][0] = 1;
			}
			if(i<n){
				dp[0][i] = 1;
			}
		}

		return dp;
	}

}
