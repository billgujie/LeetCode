package solution.leetcode.jieGu;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null){
        	return head;
        }
        // init m node and n node
        ListNode mNode = head;
        ListNode nNode = head;
        // previous node of node m
        ListNode mPreNode = new ListNode(0);
        mPreNode.next = head;
        for (int i=0; i<n-m; i++) {
        	nNode = nNode.next;
        }
        
        // locate node m and node n
        for (int i=0; i<m-1; i++){
            mPreNode = mNode;
            mNode = mNode.next;
            nNode = nNode.next;
        }
        
        // check if case of reversing from head
        boolean fromHead = false;
        if(mNode == head) fromHead = true;
        
        // reverse node range
        while(mNode!=nNode){
            ListNode temp = nNode.next;
            nNode.next = mNode;
            mPreNode.next = mNode.next;
            mNode.next = temp;
            mNode = mPreNode.next;
        }
        
        // case of reverse started from head
        if(fromHead == true) return nNode;
        
        // other cases
        return head;
    }
}
