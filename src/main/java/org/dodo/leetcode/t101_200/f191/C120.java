package org.dodo.leetcode.t101_200.f191;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ClassNum(120)
public class C120 implements ISolve {

//	给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
//	每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
//
//
//
//	示例 1：
//
//		输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//		输出：11
//		解释：如下面简图所示：
//				2
//				3 4
//				6 5 7
//				4 1 8 3
//		自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//	示例 2：
//
//		输入：triangle = [[-10]]
//		输出：-10
//
//
//	提示：
//
//			1 <= triangle.length <= 200
//			triangle[0].length == 1
//			triangle[i].length == triangle[i - 1].length + 1
//			-104 <= triangle[i][j] <= 104
//
//
//	进阶：
//
//		你	可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？

	String TAG = "三角形最小路径和";

	@Override
	public void doSth() {
		List<List<Integer>> triangle = getData();			// 11
//		List<List<Integer>> triangle = getData02();			// -10


		Lg.infoClass(TAG + "1 is " + minimumTotal(triangle));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "2 is " + minimumTotal02(triangle));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "3 is " + minimumTotal03(triangle));
	}


	public List<List<Integer>> getData() {
		List<List<Integer>> triangle = new ArrayList<>();
//		triangle.add(List.of(2));
//		triangle.add(List.of(3, 4));
//		triangle.add(List.of(6, 5, 7));
//		triangle.add(List.of(4, 1, 8, 3));

		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));

		return triangle;
	}

	public List<List<Integer>> getData02() {
		List<List<Integer>> triangle = new ArrayList<>();
//		triangle.add(List.of(-10));
		triangle.add(Arrays.asList(-10));
		return triangle;
	}

	public static int[][] convert(List<List<Integer>> list) {
		// 获取行数
		int rows = list.size();
		// 获取列数（假设每行长度相同）
		int cols = list.get(rows-1).size();

		// 创建二维数组
		int[][] array = new int[rows][cols];

		// 填充数据
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				array[i][j] = list.get(i).get(j);
			}
		}
		return array;
	}

	// dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j]
	// 逆向计算， 最后球dp[0][0] 的值
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int m = triangle.get(n-1).size();
		int[][] dp = new int[n+1][m+1];
		for(int i=n-1;i>=0;i--) {
			for(int j=triangle.get(i).size()-1;j>=0;j--) {
				dp[i][j] = Math.min(dp[i+1][j+1],dp[i+1][j]) + triangle.get(i).get(j);
			}
		}
		return dp[0][0];
	}

	//
	public int minimumTotal02(List<List<Integer>> triangle0) {
		int[][] dp = convert(triangle0);
		int n = triangle0.size();
		for(int i=n-2;i>=0;i--) {
			for(int j=triangle0.get(i).size()-1;j>=0;j--) {
				dp[i][j] = Math.min(dp[i+1][j+1],dp[i+1][j]) + dp[i][j];
			}
		}
		return dp[0][0];
	}


	public int minimumTotal03(List<List<Integer>> triangle) {
		int n = triangle.size();
		for(int i=n-2;i>=0;i--) {
			List<Integer> listIn = triangle.get(i);
			for(int j= listIn.size()-1;j>=0;j--) {
				listIn.set(j, Math.min(triangle.get(i+1).get(j+1),triangle.get(i+1).get(j)) + listIn.get(j)) ;
			}
			triangle.set(i, listIn);
		}
		return triangle.get(0).get(0);
	}

}
