package org.dodo.leetcode.t1_100.f1;


import org.dodo.leetcode.ISolve;
import org.dodo.utils.ClassNum;
import org.dodo.utils.Lg;

import java.util.Arrays;

//### 马拉车， 搞不定
@ClassNum(5)
public class C5 implements ISolve {


//	给你一个字符串 s，找到 s 中最长的 回文 子串。
//
//
//	示例 1：
//
//		输入：s = "babad"
//		输出："bab"
//		解释："aba" 同样是符合题意的答案。
//
//	示例 2：
//
//		输入：s = "cbbd"
//		输出："bb"
//
//
//	提示：
//
//		1 <= s.length <= 1000
//		s 仅由数字和英文字母组成

	String TAG = "最长回文子串";

	@Override
	public void doSth() {
		Lg.infoClass(TAG +"1 is " + longestPalindrome(getData()));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "2 is " + longestPalindrome02(getData()));
		Lg.infoClass("  =  ");
		Lg.infoClass(TAG + "3 is " + longestPalindrome03(getData()));
	}

	String getData(){
//		return "babad";
		return "cbbd";
	}

	public String longestPalindrome(String s) {
		return "";
	}

	public String longestPalindrome02(String s) {
		return "";
	}

	public String longestPalindrome03(String s) {
		return "";
	}

}
