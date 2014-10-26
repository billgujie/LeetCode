package solution.leetcode.jieGu;

public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len == 0){
        	return 0;
        }
        int sum=0;
        
        int[] candies = new int[len];
        candies[0] = 1;
        
        for (int i = 1; i < len; i++){
        	if (ratings[i] > ratings[i-1]){
        		candies[i] = candies[i-1] + 1;
        	}else{
        		candies[i] = 1;
        	}
        }
        
        for (int i = len-2; i >= 0; i--){
        	if (ratings[i] > ratings[i+1] && candies[i]<= candies[i+1]){
        		candies[i] = candies[i+1] + 1;
        	}
        }
        
        for (int i = 0; i < len; i++){
        	sum=sum+candies[i];
        }
        
        return sum;
    }
}
