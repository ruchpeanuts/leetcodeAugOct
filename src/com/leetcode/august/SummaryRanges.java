package com.leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return list;
		} else if (nums.length == 1) {
			list.add(String.valueOf(nums[0]));
			return list;
		} else {
			for (int i = 0; i < nums.length; i++) {
				int a = nums[i];
				while (i < nums.length - 1 && (nums[i + 1] - nums[i]) == 1) {
					i++;
				}
				if (a != nums[i]) {
					list.add(a + "->" + nums[i]);
				} else {
					list.add(String.valueOf(nums[i]));
				}
			}
			return list;
		}
	}

	public static void main(String[] args) {
		SummaryRanges thisClass = new SummaryRanges();
		int[] nums = { 0, 2, 3, 4, 6, 8, 9 };
		System.out.println(thisClass.summaryRanges(nums));
	}

}
