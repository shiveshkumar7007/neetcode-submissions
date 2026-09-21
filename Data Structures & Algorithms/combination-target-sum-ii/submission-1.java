class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return res;
    }

    public void helper(int[] nums, int target, int index) {
        if (target < 0 ) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

           

            curr.add(nums[i]);
            helper(nums, target - nums[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}