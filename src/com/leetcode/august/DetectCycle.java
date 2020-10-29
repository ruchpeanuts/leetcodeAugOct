package com.leetcode.august;

class DetectCycle {

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

	public ListNode detectCycle(ListNode head) {
		if (head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return findIntersection(head, slow);
			}
		}
		return null;
	}

	private ListNode findIntersection(ListNode head, ListNode slow) {
		while (head != slow) {
			head = head.next;
			slow = slow.next;
		}
		System.out.println(head.val);
		return head;
	}

	public static void main(String[] args) {
		DetectCycle linkedList = new DetectCycle();
		ListNode head1 = linkedList.new ListNode(3);
		ListNode head2 = linkedList.new ListNode(2);
		head1.next = head2;
		ListNode head3 = linkedList.new ListNode(0);
		head2.next = head3;
		ListNode head4 = linkedList.new ListNode(-4);
		head3.next = head4;
		head4.next = head2;
		System.out.println(linkedList.detectCycle(head1));
	}
}
