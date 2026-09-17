class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int num: nums){
            low = Math.max(num, low);
            high += num;
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canSplit(nums, k, mid)){
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public boolean canSplit(int[] nums, int k, int target){
        int part = 1;
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(currSum + nums[i] > target){
                part++;
                currSum = nums[i];
            }else{
                currSum += nums[i];
            }
        }

        return part <= k;
    }
}