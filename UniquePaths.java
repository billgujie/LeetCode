package solution.leetcode.jieGu;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m<=1 || n <=1){
        	return Math.min(m, n);
        }
        
        int[] temp = new int[n];
        temp[0] = 1;
        for (int i = 0; i < m ;i++){
        	for (int j = 1 ; j < n; j++){
        		temp[j] += temp[j-1];
        	}
        }
        return temp[n-1];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length <=0 || obstacleGrid[0].length <=0){
        	return 0;
        }
        int[] temp = new int[obstacleGrid[0].length];
        temp[0] = 1;
        
        for (int i = 0; i < obstacleGrid.length; i++){
        	for (int j = 0; j < obstacleGrid[0].length; j++){
        		if (obstacleGrid[i][j]==1){
        			temp[j]=0;
        		}else{
        			if (j>0){
        				temp[j] += temp[j-1];
        			}
        		}
        	}
        }
        return temp[obstacleGrid[0].length-1];
    }
}
