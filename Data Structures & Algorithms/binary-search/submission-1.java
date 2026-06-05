class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = nums.length-1;
        
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                l++;
            } else{
                r--;
            }

        }
        return -1;
    }
}
