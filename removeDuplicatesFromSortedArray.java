package solution.leetcode.jieGu;

public class removeDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
    	if (A.length == 0 || A.length == 1){
    		return A.length;
    	}
    	int cur = 0;
    	int next = 1;
    	while (next < A.length){
    		if (A[cur] == A[next]){
    			next++;
    		}else{
    			A[++cur] = A[next++];
    		}
    	}
    	return cur+1;
    }
    
    
    public int removeDuplicatesII(int[] A) {
        if (A.length<3){
        	return A.length;
        }
        
        int cur = 0;
        int count = 0;
        for (int i = 1; i < A.length; i++){
        	if (A[i]==A[cur]){
        		count++;
        	}else{
        		count = 0;
        	}
        	if (count < 2){
        		cur++;
        	}
        	A[cur]=A[i];
        }
        return cur+1;
    }
}
