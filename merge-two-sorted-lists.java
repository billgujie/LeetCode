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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);//dummy node
        ListNode cur = head;
        if (l1==null&&l2==null) return l1;
        if (l1==null) return l2;
        if (l2==null) return l1;
        
        while(true){
            if(l1==null){
                cur.next=l2;
                break;
            }
            if(l2==null){
                cur.next=l1;
                break;
            }
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        return head.next;
    }
}