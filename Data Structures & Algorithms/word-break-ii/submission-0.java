class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        backtrack(s, 0, set, curr, res);

        return res;
    }

    public void backtrack(
        String s, int index, Set<String> set, List<String> curr, List<String> res) {
        if (index == s.length()) {
            res.add(String.join(" ", curr));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String word = s.substring(index, i + 1);

            if (!set.contains(word)) {
                continue;
            }

            curr.add(word);
            backtrack(s, i + 1, set, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}