package solution.leetcode.jieGu;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        for (int i = 0; i< n; i++){
        	fast = fast.next;
        	count++;
        }
        
        if (count < n){
        	return head;
        }
        if (fast == null){
        	return head.next;
        }
        
        while (fast.next != null){
        	slow = slow.next;
        	fast = fast.next;
        }
        //remove
    	slow.next = slow.next.next;

        
        return head;
        
        
    }
}
