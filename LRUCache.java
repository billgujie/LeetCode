package solution.leetcode.jieGu;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private Map<Integer, DListNode> map;
	private int cap;
	private DListNode list;//head stores the oldest value
	private DListNode head;
	private DListNode tail;
	private int cur_size;
	
    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, DListNode>();
        this.cap = capacity;
        this.list =null;
        this.head=this.list;
        this.tail=this.list;
        this.cur_size=0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
        	DListNode ret = map.get(key);
        	// rearrange insertion order
        	
        	if (ret.previous!=null && ret.next!=null){
        		ret.previous.next=ret.next;
        		ret.next.previous= ret.previous;
            	ret.previous=tail;
            	ret.next=null;
            	tail.next=ret;
            	//advance tail
            	tail=tail.next;
        	}else if (ret.previous==null && ret.next!=null){
        		head=head.next;
        		head.previous=null;
        		ret.next=null;
        		ret.previous=tail;
        		tail.next=ret;
        		tail=tail.next;
        	}
        	


        	// return value
        	return ret.val;
        }else{
        	return -1;
        }
    }
    
    public void set(int key, int value) {
    	boolean isFull = false;
    	if (cur_size==cap){
    		isFull=true;
    	}
    	if (!map.containsKey(key)){// 如果没有这个key
    		if(isFull){
    			//remove oldest
    			int oldkey = head.key;
        		DListNode temp = head;
        		head = head.next;
        		if (head!=null){
        			head.previous=null;
        		}
        		if (temp!=null){
        			temp.next=null;
        		}
        		map.remove(oldkey);
        		cur_size--;
    		}
    		//append new node
    		DListNode newNode = new DListNode(key, value);
    		
    		if (cur_size==0){//if its first insert
    			tail=newNode;
    			head=newNode;
    		}else{
    			//advance tail
    			newNode.previous=tail;
        		tail.next=newNode;
        		tail=tail.next;
    		}
    		
    		map.put(key, newNode);
    		cur_size++; //如果满了，就和上面的--抵消
    	} else if (map.containsKey(key)){//如果已经有了这个key
    		map.get(key).val=value;
    		this.get(key);
    	}
    }
    
    //double linked list
    public class DListNode {
    	public int val;
    	public int key;
    	public DListNode next;
    	public DListNode previous;
    	public DListNode(int key, int val) {
    		this.val = val;
    		this.key= key;
    		next = null;
    		previous=null;
    	}
    }
}
