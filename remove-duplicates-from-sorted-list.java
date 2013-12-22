/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode cur = head;
        ListNode nex = head.next;
        while(nex!=null){
            if (cur.val==nex.val){
                nex=nex.next;
                cur.next=nex;
            }else{
                //cur.next=nex;
                if (nex==null){
                    break;
                    }
                    cur=cur.next;
                    nex=nex.next;
            }
        }
        return head;
    }
}