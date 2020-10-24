package com.leetcode.august;

public class IsPalindrom {

	public boolean isPalindrom(String s) {
		if (s == null || s.isBlank())
			return true;
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
				continue;
			}
			if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsPalindrom thisClass = new IsPalindrom();
		System.out.println(thisClass.isPalindrom("Aman, a plan, a canal: Panama"));

	}

}
