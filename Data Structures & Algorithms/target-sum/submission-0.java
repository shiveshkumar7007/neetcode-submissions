class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, 0, nums, target);
    }

    private int dfs(int i, int sum, int[] nums, int target) {
        // Used all numbers
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        // Choose +
        int add = dfs(i + 1, sum + nums[i], nums, target);

        // Choose -
        int subtract = dfs(i + 1, sum - nums[i], nums, target);

        return add + subtract;
    }
}