class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        // dp[index][remainingAmount]
        dp = new Integer[coins.length][amount + 1];
        return solve(0, amount, coins);
    }
    public int solve(int index, int amount, int[] coins) {
        if (amount == 0){
            return 1;
        }
        if (index == coins.length){
            return 0;
        }
        if (dp[index][amount] != null){
            return dp[index][amount];
        }
        int take = 0;

        // Take current coin
        if (coins[index] <= amount) {
            take = solve(index, amount - coins[index], coins);
        }

        // Skip current coin
        int notTake = solve(index + 1, amount, coins);

        return dp[index][amount] = take + notTake;
    }
}