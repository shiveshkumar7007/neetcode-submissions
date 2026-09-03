class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for(int x: stones){
            total += x;
        }
        int target = total/2;
        int n = stones.length;
        Integer[][] dp = new Integer[n+1][target+1];

        int closestHalfSum = helper(stones, 0, target, dp);
        int res = total - 2 * closestHalfSum;
        return res;
    }

    public int helper(int[] stones, int i, int target, Integer[][] dp){
        if(i >= stones.length || target == 0){
            return 0;
        }
        if(dp[i][target] != null){
            return dp[i][target];
        }
        if(stones[i] > target){
            return dp[i][target] = helper(stones, i+1, target, dp);
        }

        return dp[i][target] = Math.max(stones[i] + helper(stones, i+1, target-stones[i], dp), helper(stones, i+1, target, dp));
    }
}