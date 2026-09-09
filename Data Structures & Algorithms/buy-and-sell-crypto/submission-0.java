class Solution {
    int maxProfit = Integer.MIN_VALUE;
    public int maxProfit(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit < 0 ? 0 : maxProfit;
    }
}
