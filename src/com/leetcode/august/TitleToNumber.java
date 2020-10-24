package com.leetcode.august;

public class TitleToNumber {

	public int titleToNumber(String s) {
		int tot = 0;
		if (s.length() == 1) {
			return (s.charAt(0) - 'A') + 1;
		} else if (s.length() < 1)
			return 0;
		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			int diff = (c - 'A') + 1;
//			if (i != s.length() - 1) {
//				while (--diff != 0) {
//					tot += 26;
//				}
//				tot += Math.pow(26, (i + 1));
//			} else {
//				tot += diff;
//			}
			tot= tot* 26 + (s.charAt(i) - 'A' + 1);
		}
		return tot;
	}

	public static void main(String[] args) {
		TitleToNumber thisClass = new TitleToNumber();
		System.out.println(thisClass.titleToNumber("AJHX"));

	}

}
