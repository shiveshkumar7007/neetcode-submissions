class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n+1][2];
        return helper(prices, 0, false, dp);
    }

    public int helper(int[] prices, int i, boolean holding, Integer[][] dp) {
        if (i >= prices.length) {
            return 0;
        }

        int state = holding? 1:0;

        if(dp[i][state] != null){
            return dp[i][state];
        }

        if (holding) {
            return dp[i][state] = Math.max(
                helper(prices, i + 1, true, dp),
                prices[i] + helper(prices, i + 2, false, dp)
            );
        }

        return dp[i][state] = Math.max(
            helper(prices, i + 1, false, dp),
            -prices[i] + helper(prices, i + 1, true, dp)
        );
    }
}