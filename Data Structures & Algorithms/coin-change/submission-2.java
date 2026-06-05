class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = helper(amount, coins, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int helper(int amount, int[] coins, int[] dp) {
        if (amount == 0) {
            return 0;
            
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {

            int res = helper(amount - coin, coins, dp);

            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + res);
            }
        }

        dp[amount] = min;

        return dp[amount];
    }
}