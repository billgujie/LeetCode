package solution.leetcode.jieGu;

public class removeDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode nxt = dummy.next;
        while (nxt!=null && nxt.next!=null){
            if (nxt.next.val != nxt.val){
                cur = cur.next;
                nxt = nxt.next;
            }else{
                while (nxt.next != null && nxt.val == nxt.next.val){
                    nxt = nxt.next;
                }
                cur.next = nxt.next;
                nxt = nxt.next;
            }
        }
        return dummy.next;
    }
}
