class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int r = n-1;
        int l = 0;
        while(l < r){
            if(nums[l] % 2 == 0){
                l++;
                continue;
            }
            if(nums[r] % 2 != 0){
                r--;
                continue;
            }
            if(nums[l] % 2 != 0){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                
            }
            r--;
            l++;
        }
        return nums;
    }
}