public class MergeSort_BottomUp {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		int len = 0;
		int width;
		int i;

		ListNode count = head;
		// get length of list
		while (count != null) {
			count = count.next;
			len++;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		for (width = 1; width < len; width = 2 * width) {
			// Combine pairs of array a of width "width"
			ListNode newStart = dummy;
			for (i = 0; i < len; i = i + 2 * width) {
				newStart = merge(newStart, width);
			}
		}

		return dummy.next;
	}

	public ListNode merge(ListNode newStart, int width) {
		if (newStart == null || newStart.next == null) {
			return null;
		}
		
		//	IMPORTANT! FIND STARTING POSITION INSIDE MERGE TO SAVE TIME
		ListNode left = newStart.next;
		ListNode middle = walkto(left, width);
		ListNode right = walkto(middle, width);

		ListNode start1 = left;
		ListNode start2 = middle;

		while (start1 != middle || start2 != right) {
			//this is a minimized version of traditional merge, hope to speed up the process?
			if ((start2 == right) || (start1!=middle && (start1.val < start2.val))) {
				newStart.next = start1;
				start1 = start1.next;
				newStart = newStart.next;
			} else {
				newStart.next = start2;
				start2 = start2.next;
				newStart = newStart.next;
			}
		}
		newStart.next = right;
		return newStart;
	}

	public ListNode walkto(ListNode head, int pos) {
		for (int i = 0; i < pos; i++) {
			if (head==null)
				return null;
			head = head.next;
		}
		return head;
	}

}