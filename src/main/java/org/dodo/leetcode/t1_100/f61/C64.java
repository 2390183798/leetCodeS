package org.dodo.leetcode.t1_100.f61;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

import java.util.Arrays;

@ClassNum(64)
public class C64 implements ISolve {

//	给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//	说明：每次只能向下或者向右移动一步。
//
//
//
//	示例 1：
//
//		输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//		输出：7
//		解释：因为路径 1→3→1→1→1 的总和最小。
//
//	示例 2：
//
//		输入：grid = [[1,2,3],[4,5,6]]
//		输出：12
//
//
//	提示：
//
//		m == grid.length
//		n == grid[i].length
//		1 <= m, n <= 200
//		0 <= grid[i][j] <= 200

	String TAG = "最小路径和";

	@Override
	public void doSth() {
//		int[][] grid = new int[][]{ {1,3,1} ,{1,5,1}, {4,2,1} };
		int[][] grid = new int[][]{ {1,2,3} ,{4,5,6} };

		Lg.infoClass(TAG +"1 is " + minPathSum(getCopyData(grid)));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "2 is " + minPathSum02(getCopyData(grid)));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "3 is " + minPathSum03(getCopyData(grid)));
//		Lg.infoClass("  =  ");
//		Lg.infoClass(TAG + "4 is " + minPathSum04(getCopyData(grid)));
	}

	int[][] getCopyData(int[][] grid){
		int[][] copy = grid.clone();
//        System.arraycopy(grid, 0, copy, 0, copy.length);
		for(int i=0; i<copy.length; i++){
			copy[i] = grid[i].clone();
		}
		return copy;
	}

	public int minPathSum(int[][] grid) {
		int sizeL = grid.length;
		int sizeC = grid[0].length;
		int[][] dp = new int[sizeL][sizeC];

		dp[0][0] = grid[0][0];

		for(int i = 1; i < sizeL; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}

		for(int j = 1; j < sizeC; j++) {
			dp[0][j] = dp[0][j-1] + grid[0][j];
		}

		for(int i = 1; i < sizeL; i++) {
			for(int j = 1; j < sizeC; j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}

		return dp[sizeL-1][sizeC-1];
	}

	public int minPathSum02(int[][] grid) {
		int[][] copy = grid.clone();
		int sizeL = grid.length;
		int sizeC = grid[0].length;
		for(int m=0; m<sizeL; m++){
			for(int n=0; n<sizeC; n++){
				if(m == 0 || n == 0){
					if(m ==0 && n != 0){  // 第1列
						copy[m][n] = copy[m][n] + copy[m][n-1];
					} else if( m != 0){
						copy[m][n] = copy[m][n] + copy[m-1][n];
					}
				} else {
					copy[m][n] = copy[m][n] + Math.min(copy[m][n-1] , copy[m-1][n]);
				}
			}
		}

		return copy[sizeL-1][sizeC-1];
	}

	public int minPathSum03(int[][] grid) {
		int sizeL = grid.length;
		int sizeC = grid[0].length;
		for(int m=0; m<sizeL; m++){
			for(int n=0; n<sizeC; n++){
				if(m == 0 || n == 0){
					if(m ==0 && n != 0){  // 第1列
						grid[m][n] = grid[m][n] + grid[m][n-1];
					} else if( m != 0){
						grid[m][n] = grid[m][n] + grid[m-1][n];
					}
				} else {
					grid[m][n] = grid[m][n] + Math.min(grid[m][n-1] , grid[m-1][n]);
				}
			}
		}
		return grid[sizeL-1][sizeC-1];
	}

	public int minPathSum04(int[][] grid) {
		return 0;
	}


}
