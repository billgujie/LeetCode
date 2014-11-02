package solution.leetcode.jieGu;

public class ContainerWithMaxWater {
    public int maxArea(int[] height) {
        if (height.length<=1){
        	return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int maxA = 0;
        while (start < end){
        	int tmp = (end-start) * Math.min(height[start], height[end]);
        	maxA = Math.max(maxA, tmp);
        	
        	if (height[start]<=height[end]){
        		start++;
        	}else{
        		end--;
        	}
        }
        return maxA;
    }
}
