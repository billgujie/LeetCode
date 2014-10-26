package solution.leetcode.jieGu;

import java.util.ArrayList;

public class BestTimetoBuyandSellStock {
	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i. Design an algorithm to find the maximum profit. You may
	 * complete at most two transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 * 
	 * @param prices
	 * @return
	 */
    public int maxProfitIII(int[] prices) {
        if(prices.length == 0) return 0;
        int ans = 0;
        int n = prices.length;

        //正向遍历，opt[i]表示 prices[0...i]内做一次交易的最大收益.
        int opt[] = new int[n];
        opt[0] = 0;
        int low = prices[0];
        int curAns = 0;
        for(int i = 1; i<n; i++){
            if(prices[i] < low) low = prices[i];
            else if(curAns < prices[i] - low) curAns = prices[i] - low;
            opt[i] = curAns;
        }

        //逆向遍历, opt[i]表示 prices[i...n-1]内做一次交易的最大收益.
        int optReverse[] = new int[n];
        optReverse[n - 1] = 0;
        curAns = 0;
        int high = prices[n - 1];
        for(int i=n-2; i>=0; i--){
            if(prices[i] > high) high = prices[i];
            else if(curAns < high - prices[i]) curAns = high - prices[i];
            optReverse[i] = curAns;
        }

        //再进行划分，分别计算两个部分
        for(int i=0; i<n; i++){
            int tmp = opt[i] + optReverse[i];
            if(ans < tmp) ans = tmp;
        }
        return ans;
    }

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i. Design an algorithm to find the maximum profit. You may
	 * complete as many transactions as you like (ie, buy one and sell one share
	 * of the stock multiple times). However, you may not engage in multiple
	 * transactions at the same time (ie, you must sell the stock before you buy
	 * again).
	 * 
	 * @return
	 */
	public int maxProfitII(int[] prices) {
		if (prices.length == 0)
			return 0;
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}
}
