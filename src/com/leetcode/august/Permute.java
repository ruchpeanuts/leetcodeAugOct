package com.leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class Permute {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		permute(res, new ArrayList<>(), nums);
		return res;
	}

	public void permute(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue;
				tempList.add(nums[i]);
				permute(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Permute thisClass = new Permute();
		int[] nums = { 1, 2, 3 };
		System.out.println(thisClass.permute(nums));
	}
}
