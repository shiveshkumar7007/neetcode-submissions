class Solution {
    public int[] productExceptSelf(int[] nums) {
        int countZero = 0;
        int posZero = -1;
        int prod = 1;
        int[] res = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != 0){
                prod *= nums[i];
            }
            
            if(nums[i] == 0 && countZero == 0){
                posZero = i;
            }
            if(nums[i] == 0){
                countZero++;
                if(countZero > 1){
                    return res;
                }
            }

        }

        if(countZero > 0){
            res[posZero] = prod;
            return res;
        }

        for(int i = 0; i<nums.length; i++){
            res[i] = prod / nums[i];

        }
        return res;
    }
}  
