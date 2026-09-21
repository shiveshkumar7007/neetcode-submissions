class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, n, k, new ArrayList<>(), res);
        return res;
    }

    public void helper(int start, int n, int k, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (start > n) {
            return;
        }

        // Take start
        curr.add(start);
        helper(start + 1, n, k, curr, res);
        curr.remove(curr.size() - 1);

        // Don't take start
        helper(start + 1, n, k, curr, res);
    }
}