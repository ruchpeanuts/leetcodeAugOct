package com.leetcode.august;

class InsertionSortList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			next = null;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode node = new ListNode(0);
		ListNode helper = node;
		while (head != null) {
			ListNode next = head.next;
			if(helper.val >= head.val) {
				helper=node;
			}
			while (helper.next != null && helper.next.val < head.val) {
				helper = helper.next;
			}
			head.next=helper.next;
			helper.next = head;
			head = next;
		}
		return node.next;
	
	}

	public static void main(String[] args) {
		InsertionSortList linkedList = new InsertionSortList();
		ListNode head1 = linkedList.new ListNode(4);
		ListNode head2 = linkedList.new ListNode(2);
		head1.next = head2;
		ListNode head3 = linkedList.new ListNode(1);
		head2.next = head3;
		ListNode head4 = linkedList.new ListNode(3);
		head3.next = head4;
		System.out.println(linkedList.insertionSortList(head1));
	}
}
