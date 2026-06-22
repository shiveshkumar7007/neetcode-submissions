class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        boolean[] vis = new boolean[nums.length];
        helper(nums, new ArrayList<>(), res, vis);

        return res;
    }

    public void helper(int[] nums, List<Integer> curr, List<List<Integer>> res, boolean[] vis) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]){
                continue;
            }

            vis[i] = true;
            curr.add(nums[i]);

            helper(nums, curr, res, vis);

            curr.remove(curr.size() - 1);
            vis[i] = false;
        }
    }
}