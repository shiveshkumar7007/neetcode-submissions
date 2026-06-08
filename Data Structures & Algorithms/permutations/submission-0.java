class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        backtrack(nums, vis, res, perm);
        return res;        
    }

    public void backtrack(int[] nums, boolean[] vis, List<List<Integer>> res, List<Integer> perm){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(vis[i]){
                continue;
            }
            vis[i] = true;
            perm.add(nums[i]);
            backtrack(nums, vis, res, perm);
            perm.remove(perm.size() - 1);
            vis[i] = false;
        }
    }
}
