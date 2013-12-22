public class Solution {
    public int maxProfit(int[] prices) {
        //O(n)
        if (prices.length==0){
            return 0;
        }
        int lowestprice=prices[0];
        int maxprofit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<lowestprice){
                lowestprice=prices[i];
            }
            if((prices[i]-lowestprice)>maxprofit){
                maxprofit=(prices[i]-lowestprice);
            }
        }
        return maxprofit;
    }
}