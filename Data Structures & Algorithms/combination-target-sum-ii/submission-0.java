class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] candidates, int target, int index, List<Integer> curr, List<List<Integer>> res){
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i = index; i < candidates.length; i++){
            // Skip duplicates at same level
            if(i > index && candidates[i] == candidates[i - 1]){
                continue;
            }

            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}