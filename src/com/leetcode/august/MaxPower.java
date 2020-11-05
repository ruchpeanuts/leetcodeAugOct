package com.leetcode.august;

public class MaxPower {

	public int maxPower(String s) {
		int count = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int j = 0;
			while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
				j++;
				i++;
				count = Math.max(count, j);
			}
		}
		return count + 1;
	}

	public static void main(String[] args) {
		MaxPower thisClass = new MaxPower();
		System.out.println(thisClass.maxPower("ccbccbb"));
	}

}
