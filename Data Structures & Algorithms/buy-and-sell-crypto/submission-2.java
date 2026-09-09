class Solution {
    int maxProfit = Integer.MIN_VALUE;
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        while (r < prices.length) {
            if (prices[l] > prices[r]) {
                l=r;
                r++;
            } else {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(profit, maxProfit);
                r++;
            }
        }
        return maxProfit < 0 ? 0 : maxProfit;
    }
}
