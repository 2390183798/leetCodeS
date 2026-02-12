package org.dodo.leetcode.t901_1000.f931;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ClassNum(931)
public class C931 implements ISolve {


//	给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
//
//	下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
//
//
//
//	示例 1：
//
//		输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//		输出：13
//		解释：如图所示，为和最小的两条下降路径
//
//	示例 2：
//
//		输入：matrix = [[-19,57],[-40,-5]]
//		输出：-59
//		解释：如图所示，为和最小的下降路径
//
//
//	提示：
//
//		n == matrix.length == matrix[i].length
//		1 <= n <= 100
//		-100 <= matrix[i][j] <= 100



	String TAG = "下降路径最小和";

	@Override
	public void doSth() {
//		[2,1,3],[6,5,4],[7,8,9]
//		int[][] data = new int[][]{{2,1,3}, {6,5,4}, {7,8,9}};	// 13
//		int[][] data = new int[][]{{-19,57}, {-40,-5}};	// -59


		Lg.infoClass(TAG + "1 is " + minFallingPathSum(getData()));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "2 is " + minFallingPathSum02(getData()));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "3 is " + minFallingPathSum03(getData()));
	}

	int[][] getData(){
		return new int[][]{{2,1,3}, {6,5,4}, {7,8,9}}; 	// 13
//		return new int[][]{{-19,57}, {-40,-5}};			// -59
	}


	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		int[][] dp = new int[n][n];
		if(n == 1){
			return matrix[0][0];
		}
		int minNum = Integer.MAX_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(i==0){
					dp[i][j] = matrix[i][j];
				} else {
					boolean hasT = (j!=0);
					boolean hasE = (j!=n-1);
					if(hasT && hasE){
						dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
					} else if(hasT){
						dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
					} else if(hasE){
						dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
					}
					if(i==n-1){
						minNum = Math.min(minNum, dp[i][j]);
					}
				}
			}
		}
		return minNum;
	}

	//
	public int minFallingPathSum02(int[][] matrix) {
		int n = matrix.length;
		if(n == 1){
			return matrix[0][0];
		}
		int minNum = Integer.MAX_VALUE;
		for(int i=1; i<n; i++){
			for(int j=0; j<n; j++){
				boolean hasT = (j!=0);
				boolean hasE = (j!=n-1);
				if(hasT && hasE){
					matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i-1][j+1]));
				} else if(hasT){
					matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j-1]);
				} else if(hasE){
					matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j+1]);
				}
				if(i==n-1){
					minNum = Math.min(minNum, matrix[i][j]);
				}

			}
		}
		return minNum;
	}

	public int minFallingPathSum03(int[][] matrix) {
		int n = matrix.length;
		if(n == 1){
			return matrix[0][0];
		}
		int minNum = Integer.MAX_VALUE;
		for(int i=1; i<n; i++){
			for(int j=0; j<n; j++){
				matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], Math.min(
						(j!=0)?matrix[i-1][j-1] :Integer.MAX_VALUE,
						(j!=n-1)?matrix[i-1][j+1] :Integer.MAX_VALUE));

				if(i==n-1){
					minNum = Math.min(minNum, matrix[i][j]);
				}
			}
		}
		return minNum;
	}

}
