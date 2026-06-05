class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int n = nums.length;
        int max[] = new int[n];
        int min[] = new int[n];
        max[0] = min[0] = nums[0];

        for(int i = 1; i < n; i++){
            int a = max[i-1] * nums[i];
            int b = min[i-1] * nums[i];
            max[i] = Math.max(a, Math.max(b, nums[i]));
            min[i] = Math.min(a, Math.min(b, nums[i]));

            res = Math.max(max[i], res);
        }
        // Arrays.sort(max);
        return res;

    }
}
