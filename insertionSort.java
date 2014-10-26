package solution.leetcode.jieGu;

public class insertionSort {
    public ListNode insertionSortList(ListNode head) {
    	if (head==null || head.next==null){
    		return head;
    	}
    	
        ListNode ret_dummy = new ListNode(0);
        ret_dummy.next=head;
        
        //cur is always ahead of sorted
        ListNode sorted = head;
        ListNode cur = head.next;

        while(cur!=null){
            if (cur.val>=sorted.val){
            	sorted=sorted.next;
            	cur=cur.next;
            }else{
                ListNode pre = ret_dummy;
                while(pre.next.val<cur.val){
                	pre=pre.next;
                }
                //pre is the last value that is less than cur
                //insert cur after pre
                sorted.next=cur.next;
                cur.next=pre.next;
                pre.next=cur;
                
                cur=sorted.next;
            }
        }
        return ret_dummy.next;
        
    }
}
