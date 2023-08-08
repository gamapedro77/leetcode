package BestTimeToBuyAndSellStock;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(maxProfit(new int[] {2,4,1}));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int length = prices.length;
        int lastBuy = 0;
        for (int i = 0; i < length; i++) {
            if(prices[lastBuy] > prices[i]) {
                lastBuy = i;
            }
            profit = Math.max(profit, prices[i] - prices[lastBuy]);
        }
        return profit;
    }
}
