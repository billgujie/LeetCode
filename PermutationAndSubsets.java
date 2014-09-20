package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationAndSubsets {
	
	/**
	 * subset I
	 * 输入数组没有重复元素
	 * 
	 * @author Gu
	 *
	 */
	public class subsetsI{
		public ArrayList<ArrayList<Integer>> subsets(int[] S){
			
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			//sort the array
			Arrays.sort(S);
			
			result.add(temp);
			
			dfs(result, temp, S, 0);
			
			return result;
		}
		
		public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] S, int pos){
			
			//每次新加一个元素都属于subset
			for (int i = 0; i < S.length; i++){
				tmp.add(S[i]);
				res.add(new ArrayList<Integer>(tmp));
				dfs(res, tmp, S, i+1);
				tmp.remove(tmp.size()-1);
			}
		}
	}
	
	//subsetsII 去除重复的答案
	public class subsetsII{
		public ArrayList<ArrayList<Integer>> subsets(int[] S){
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> tmp =  new ArrayList<Integer>();
			Arrays.sort(S);
			res.add(tmp);
			
			dfs(res, tmp, S, 0);
			
			return res;
		}
		
		public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] S, int pos){
			
			for (int i = pos; i < S.length; i++){
				tmp.add(S[i]);
				res.add(new ArrayList<Integer>(tmp));
				dfs(res, tmp, S, i+1);
				tmp.remove(tmp.size()-1);
				while (i < S.length-1 && S[i]==S[i+1]){
					i++;
				}
			}
		}
	}
	
	//permutation I
	//permutation is different from subsets problems:
	// 1. tmp array must be filled to a certain size before added into result
	// 2. can not use pos to track next starting position, otherwise we will forget some numbers
	public class permutationI{
		public ArrayList<ArrayList<Integer>> permute(int[] num){
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			boolean [] visited = new boolean[num.length];
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			Arrays.sort(num);
			dfs(res, tmp, num, visited);
			return res;
		}
		
		public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, boolean[] visited){
			if (tmp.size() == num.length){
				res.add(new ArrayList<Integer>(tmp));
				return;
			}else{
				for (int i = 0; i < num.length; i++){
					if ( !visited[i] ){
						tmp.add(num[i]);
						visited[i]=true;
						dfs(res, tmp, num, visited);
						tmp.remove(tmp.size()-1);
						visited[i]=false;
					}
				}
			}
		}
	}
	
	public class permutationII{
		public ArrayList<ArrayList<Integer>> permuteUnique(int[] num){
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			boolean[] visited = new boolean[num.length];
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			Arrays.sort(num);
			int a = Integer.MAX_VALUE * 10;
			dfsUnique(res, tmp, num, visited);
			
			return res;
		}
		
		public void dfsUnique(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, boolean[] visited){
			if (tmp.size() == num.length){
				res.add(new ArrayList<Integer>(tmp));
				return;
			}else{
				for (int i = 0; i < num.length; i++){
					if ( !visited[i] ){
						tmp.add(num[i]);
						visited[i] = true;
						dfsUnique(res, tmp, num, visited);
						tmp.remove(tmp.size()-1);//back tracking
						visited[i] = false;
						
						//skip duplicate
						while (i < num.length-1 && num[i] == num[i+1]){
							i++;
						}
					}
				}
			}
		}
	}

}
