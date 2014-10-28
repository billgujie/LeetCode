package solution.leetcode.jieGu;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
        	return 0;
        }
        int[] temp = new int[grid[0].length];
        temp[0] = grid[0][0];
        
        //fill first row
        for (int i =1; i< grid[0].length; i++){
        	temp[i] = temp[i-1] + grid[0][i];
        }
        
        for(int i = 1; i < grid.length; i++){
        	for(int j = 0; j < grid[0].length; j++){
        		if (j==0){
        			temp[j]=temp[j]+grid[i][j];
        		}else{
        			temp[j] = Math.min(temp[j], temp[j-1])+grid[i][j];
        		}
        	}
        }
        return temp[grid[0].length-1];
    }
}
