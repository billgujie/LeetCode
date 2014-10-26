package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public class combinationSumI{
	    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    	ArrayList<Integer> tmp = new ArrayList<Integer>();
	    	Arrays.sort(candidates);
	    	dfs(res, tmp, candidates, target, 0);
	    	return res;
	    }
	    
	    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[]S, int target, int pos){
	    	
	    	if (target < 0){
	    		return;
	    	}else if (target == 0){
	    		res.add(new ArrayList<Integer>(tmp));
	    	}
	    	
	    	
			for (int i = pos; i < S.length; i++){
				tmp.add(S[i]);
				dfs(res, tmp, S, target - S[i], i);
				tmp.remove(tmp.size()-1);
			}
	    }
	}
	

}
