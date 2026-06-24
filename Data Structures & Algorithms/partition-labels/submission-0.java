class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> map = new HashMap<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, new int[]{i, i});
            } else {
                map.get(ch)[1] = i;
            }
        }

        List<int[]> intervals = new ArrayList<>(map.values());
        intervals.sort((a, b) -> a[0] - b[0]);

        List<Integer> ans = new ArrayList<>();

        int start = intervals.get(0)[0];
        int end   = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            int[] curr = intervals.get(i);

            if (curr[0] < end) {
                end = Math.max(end, curr[1]);
            } else {
                ans.add(end - start + 1);
                start = curr[0];
                end = curr[1];
            }
        }
        ans.add(end - start + 1);
        return ans;
    }
}