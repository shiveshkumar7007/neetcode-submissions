class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int max = 0;
        for(int num: nums){
            int len = 0;
            if(set.contains(num-1)){
                continue;
            }
            while(set.contains(num)){
                len++;
                num++;
            }
            max = max > len ? max:len;
        }
        return max;
        
    }
}
