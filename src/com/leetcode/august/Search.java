package com.leetcode.august;

public class Search {

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int length = nums.length;
		return search(nums, 0, length - 1, target);
	}

	private int search(int a[], int low, int high, int key) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] < key) {
				low = mid + 1;
			} else if (a[mid] > key) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		Search thisClass = new Search();
		System.out.println(thisClass.search(nums, -9));

	}

}
