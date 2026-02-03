package org.dodo;

import org.dodo.leetcode.ISolve;
import org.dodo.leetcode.t501_600.StApp501;
import org.dodo.leetcode.t701_800.StApp701;

public class LeetCodeApplication {

	public static void main(String[] args) {
		ISolve solve = null;
		solve = new StApp501();
//		solve = new StApp701();
		solve.doSth();
	}

}
