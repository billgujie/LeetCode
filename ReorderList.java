package solution.leetcode.jieGu;

public class ReorderList {
	
	/**
	 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
	 * reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
	 * You must do this in-place without altering the nodes' values.
	 * 
	 * For example,
	 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 * @param head
	 */
    public void reorderList(ListNode head) {
        // split list into half: H1, H2
    	// reverse H2 and merge with H1
    	if (head == null || head.next == null){
    		return;
    	}
    	

    	ListNode fast = head;
    	ListNode slow = head;
    	while (fast != null && fast.next != null){
    		slow=slow.next;
    		fast = fast.next.next;
    	}
    	
    	ListNode reverse = slow.next;
    	slow.next = null;
    	reverse = reverseList(reverse);
    	
    	ListNode ptr1 = head;
    	ListNode ptr2 = reverse;
    	while (reverse != null){
    		ListNode temp = reverse.next;
    		reverse.next = ptr1.next;
    		ptr1.next = reverse;
    		ptr1 = ptr1.next.next;
    		reverse = temp;	
    	}
    	
    }
    
    public ListNode reverseList(ListNode head){
    	if (head == null || head.next == null){
    		return head;
    	}
    	ListNode prev = null;
    	ListNode cur = head;
    	ListNode next = head.next;
    	
    	while (next != null){
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    		next = next.next;
    	}
    	
    	cur.next=prev;
    	
    	return cur;
    }
    
}
