class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int i = 0; i<len; i++){
            curr += nums[i];
            max = Math.max(curr, max);
            if(curr < 0){
                curr = 0;
            }
        }
        return max;
    }
}
