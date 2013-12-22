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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0;
        ListNode res = null;
        ListNode cur = null;
        ListNode i1 = l1;
        ListNode i2 = l2;
        while(i1!=null||i2!=null){
            int num1 = i1 == null? 0 : i1.val;
            int num2 = i2 == null? 0 : i2.val;
            int temp = num1+num2+c;
            if (temp>=10){c=1;}else{c=0;}
            if (res==null){
                res=new ListNode(temp%10);
                cur=res;
            }else{
                cur.next=new ListNode(temp%10);
                cur=cur.next;
            }
            i1 = i1 == null? null: i1.next;
            i2 = i2 == null? null: i2.next;
        }
        if (c==1){
            cur.next=new ListNode(1);
        }
        return res;
    }
}