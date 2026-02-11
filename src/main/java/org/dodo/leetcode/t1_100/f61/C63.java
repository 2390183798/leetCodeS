package org.dodo.leetcode.t1_100.f61;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

@ClassNum(63)
public class C63 implements ISolve {

//	给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
//
//	网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
//
//	返回机器人能够到达右下角的不同路径数量。
//
//	测试用例保证答案小于等于 2 * 109。
//
//
//
//	示例 1：
//
//		输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//		输出：2
//		解释：3x3 网格的正中间有一个障碍物。
//		从左上角到右下角一共有 2 条不同的路径：
//				1. 向右 -> 向右 -> 向下 -> 向下
//				2. 向下 -> 向下 -> 向右 -> 向右
//
//	示例 2：
//
//		输入：obstacleGrid = [[0,1],[0,0]]
//		输出：1
//
//
//	提示：
//
//		m == obstacleGrid.length
//		n == obstacleGrid[i].length   1 <= m, n <= 100
//		obstacleGrid[i][j] 为 0 或 1

	String TAG = "不同路径 II";

	@Override
	public void doSth() {
		int[][] grid = new int[][]{ {0,0,0} ,{0,1,0}, {0,0,0} };  // 2
//		int[][] grid = new int[][]{ {0,1} ,{0,0} };  // 1
//		int[][] grid = new int[][]{ {1,0} ,{0,0} };  // 0
//		int[][] grid = new int[][]{ {0,0},{1,1} ,{0,0} };  // 0
//		int[][] grid = new int[][]{ {1,0}};  // 0

		Lg.infoClass(TAG +"1 is " + uniquePathsWithObstacles(getCopyData(grid)));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "2 is " + uniquePathsWithObstacles02(getCopyData(grid)));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "3 is " + uniquePathsWithObstacles03(getCopyData(grid)));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "4 is " + uniquePathsWithObstacles04(getCopyData(grid)));
	}

	int[][] getCopyData(int[][] grid){
		int[][] copy = grid.clone();
		for(int i=0; i<copy.length; i++){
			copy[i] = grid[i].clone();
		}
		return copy;
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int sizeL = obstacleGrid.length;
		int sizeC = obstacleGrid[0].length;
		int[][] dp = new int[sizeL][sizeC];      // 创建 dp 数组
		for (int i = 0; i < sizeL && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;
		for (int j = 0; j < sizeC && obstacleGrid[0][j] == 0; j++) dp[0][j] = 1;

		for (int i = 1; i < sizeL; i++) {
			for (int j = 1; j < sizeC; j++) {
				if (obstacleGrid[i][j] == 0)
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // 递推公式
			}
		}
		return dp[sizeL - 1][sizeC - 1];
	}

	public int uniquePathsWithObstacles02(int[][] obstacleGrid) {
		int sizeL = obstacleGrid.length;
		int sizeC = obstacleGrid[0].length;
		return 0;
	}

	public int uniquePathsWithObstacles03(int[][] obstacleGrid) {

		return 0;
	}

	public int uniquePathsWithObstacles04(int[][] obstacleGrid) {
		return 0;
	}


}
