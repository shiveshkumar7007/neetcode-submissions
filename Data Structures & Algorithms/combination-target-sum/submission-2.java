class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(nums, target, 0);
        return res;
    }

    public void helper(int[] nums, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (index >= nums.length){
            return;
        }

        curr.add(nums[index]);
        helper(nums, target - nums[index], index);
        
        curr.remove(curr.size() - 1);
        helper(nums, target, index+1);
    }
}
