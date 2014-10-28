package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if (n<0){
        	return "";
        }
        k--;//convert the sequence number
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<Integer>();
        int factorial = 1;
        for (int i = 1; i<=n; i ++){
        	nums.add(i);
        }
        for (int i = 2; i < n; i++){
        	factorial *= i;
        }
        
        for (int i = n - 1; i >=0 ; i--){
        	int index = k/factorial;
        	k %= factorial;
        	sb.append(nums.get(index));
        	nums.remove(index);
        	if (i > 0){ // update factorial, avoid divide by zero
        		factorial /= i;
        	}
        }
        return sb.toString();
    }
}
