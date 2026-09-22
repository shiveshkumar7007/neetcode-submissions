class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        if (n < k) {
            return false;
        }
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
        int[] res = new int[k];

        return helper(nums, res, 0, sum / k);
    }

    public boolean helper(int[] nums, int[] res, int ind, int target) {
        if (ind == nums.length) {
            for (int i = 0; i < res.length; i++) {
                if (res[i] != target) {
                    return false;
                }
                return true;
            }
        }

        int num = nums[ind];

        for (int i = 0; i < res.length; i++) {
            if (res[i] + num > target) {
                continue;
            }
            res[i] += num;
            if (helper(nums, res, ind + 1, target)) {
                return true;
            }

            res[i] -= num;

            if (res[i] == 0) {
                break;
            }
        }

        return false;
    }
}