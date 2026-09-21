class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(nums, target, 0);
        return res;
    }

    public void helper(int[] nums, int target, int index){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(curr));
        }

        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            helper(nums, target-nums[i], i);
            curr.remove(curr.size()-1);
            
        }
    }
}
