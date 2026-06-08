class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {    
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if((sum & 1) == 1){
            return false;
        }
        dp = new Boolean[nums.length][sum/2 + 1];
        return targetSum(nums, 0, sum/2);
        
    }

    public boolean targetSum(int[] nums, int i, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (i>=nums.length) {
            return false;
        }
        if(dp[i][target] != null){
            return dp[i][target];
        }
        return dp[i][target] = targetSum(nums, i+1, target-nums[i]) || targetSum(nums, i+1, target);
    }
}
