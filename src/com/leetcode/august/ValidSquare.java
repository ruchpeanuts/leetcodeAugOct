package com.leetcode.august;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSquare {

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		Set<Integer> set = new HashSet<>(
				Arrays.asList(dist(p1, p2), dist(p1, p3), dist(p1, p4), dist(p2, p3), dist(p2, p4), dist(p3, p4)));
		return set.size() == 2 && !set.contains(0);
	}

	private int dist(int[] p1, int[] p2) {
		return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
	}

	public static void main(String[] args) {
		ValidSquare thisClass = new ValidSquare();
		int[] p1 = { 0, 5 };
		int[] p2 = { 5, 0 };
		int[] p3 = { 0, 0 };
		int[] p4 = { 5, 5 };
		System.out.println(thisClass.validSquare(p1, p2, p3, p4));

	}

}
