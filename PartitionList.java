package solution.leetcode.jieGu;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode leftdummy = new ListNode(0);
        ListNode rightdummy = new ListNode(0);
        ListNode left_p = leftdummy, right_p = rightdummy;
        
        while(head != null){
        	if (head.val < x){
        		left_p.next = head;
        		left_p = left_p.next;
        	}else{
        		right_p.next = head;
        		right_p = right_p.next;
        	}
        	head = head.next;
        }
        
        right_p.next = null;
        left_p.next = rightdummy.next;
        return leftdummy.next;
    }
}
