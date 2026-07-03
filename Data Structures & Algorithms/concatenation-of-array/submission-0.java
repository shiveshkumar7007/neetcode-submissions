class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] res = new int[len*2];
        int j = 0;
        for(int i = 0; i < len*2; i++){
            res[i] = nums[j];
            j++;
            if(j == len){
                j = 0;
            }
        }

        return res;
    }
}