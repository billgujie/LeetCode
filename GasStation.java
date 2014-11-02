package solution.leetcode.jieGu;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for (int i = 0; i< gas.length; i++){
        	diff[i] = gas[i] - cost[i];
        }
        
        int left=0, sum =0, startnode =0;
        for (int i = 0; i < gas.length; i++){
        	left += diff[i];
        	sum += diff[i];
        	
        	if (sum < 0){
        		startnode = i+1;
        		sum =0;
        	}
        }
        
        if (left<0){
        	return -1;
        }else{
        	return startnode;
        }
    }
}
