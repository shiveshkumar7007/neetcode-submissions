class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }
        if(set.size() == nums.length){
            return false;
        }

        return true;
    }
}

// current solution O(N) time and O(N) space

// if sorted O(n log n) time 