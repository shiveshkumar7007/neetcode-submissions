class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        if(len < k){
            return false;
        }
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % k != 0){
            return false;
        }
        int target = sum / k;
        int[] arr = new int[k];
        Arrays.sort(nums);
        return dfs(0, k, nums, target, arr);        
    }

    public boolean dfs(int ind, int k, int[] nums, int target, int[] arr){
        if(ind == nums.length){
            for(int i = 0; i < k; i++){
                if(arr[i] != target){
                    return false;
                }
            }
            return true;
        }

        int num = nums[ind];
        for(int i = 0; i < k; i++){
            if(num + arr[i] > target){
                continue;
            }
            arr[i] += num;

            if(dfs(ind+1, k, nums, target, arr)){
                return true;
            }

            arr[i] -= num;
            if(arr[i] == 0){
                break;
            }
        }
        return false;
    }
}