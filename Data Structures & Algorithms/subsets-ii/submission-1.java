class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        return ans;
    }

    public void backtrack(int index, int[] nums, List<Integer> curr) {
        ans.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++){
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]){
                continue;
            }
            curr.add(nums[i]);
            backtrack(i + 1, nums, curr);
            curr.remove(curr.size() - 1);
        }
    }
}