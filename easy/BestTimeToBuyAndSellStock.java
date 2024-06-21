package easy;
/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
* */
public class BestTimeToBuyAndSellStock {

    static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[l] > prices[i]) {
                l = i;
            } else if (maxProfit < prices[i] - prices[l]) {
                maxProfit = prices[i] - prices[l];
            }
        }
        return maxProfit;
    }



}
