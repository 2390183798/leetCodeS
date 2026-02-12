package org.dodo.leetcode.t201_300.f221;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

@ClassNum(221)
public class C221 implements ISolve {


//	在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
//
//
//	示例 1：
//
//		输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//		输出：4
//	示例 2：
//
//		输入：matrix = [["0","1"],["1","0"]]
//		输出：1
//
//
//	示例 3：
//
//		输入：matrix = [["0"]]
//		输出：0
//
//
//	提示：
//
//		m == matrix.length
//		n == matrix[i].length
//		1 <= m, n <= 300
//		matrix[i][j] 为 '0' 或 '1'


	String TAG = "最大正方形";

	@Override
	public void doSth() {
//		[2,1,3],[6,5,4],[7,8,9]
//		int[][] data = new int[][]{{2,1,3}, {6,5,4}, {7,8,9}};	// 13
//		int[][] data = new int[][]{{-19,57}, {-40,-5}};	// -59


		Lg.infoClass(TAG + "1 is " + maximalSquare(getData()));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "2 is " + maximalSquare02(getData()));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "3 is " + maximalSquare03(getData()));
	}

	char[][] getData(){
		return new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'},
							{'1','1','1','1','1'}, {'1','0','0','1','0'}}; 	// 4
//		return new char[][]{{'0','1'}, {'1','0'}};			// 1
//		return new char[][]{{'0'}};			// 0
	}


	public int maximalSquare(char[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[rows + 1][cols + 1];
		int maxSide = 0;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
					maxSide = Math.max(dp[i][j], maxSide);
				}
			}
		}
		return maxSide * maxSide;
	}

	//
	public int maximalSquare02(char[][] matrix) {
		return 0;
	}

	public int maximalSquare03(char[][] matrix) {
		int n = matrix.length;
		return 0;
	}

}
