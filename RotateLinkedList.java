package solution.leetcode.jieGu;

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n <= 0){
        	return head;
        }
        int len = 1;
        ListNode runner = head;
        ListNode tail = head;
        
        //get total length
        while(runner.next!=null){
        	runner = runner.next;
        	len++;
        }
        n %= len;
        if (n == 0){
        	return head;
        }
        
        //reaches the tail
        for (int i = 0; i < len - n - 1; i++){
        	tail = tail.next;
        }
        
        ListNode newHead = tail.next;
        tail.next = null;
        runner.next = head;
        
        return newHead;
        
    }
}
