package com.leetcode.august;

public class IsPowerOfFour {

	public boolean isPowerOfFour(int num) {
		if(num<1) return false;
		int t = (int) (Math.log(num) / Math.log(4));
		return (num == Math.pow(4, t));
	}

	public static void main(String[] args) {
		IsPowerOfFour thisClass = new IsPowerOfFour();
		System.out.println(thisClass.isPowerOfFour(4));

	}

}
