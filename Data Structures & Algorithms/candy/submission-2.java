class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];

        // Left to right: handle increasing ratings
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }

        // Right to left: handle decreasing ratings
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i], count[i + 1] + 1);
            }
        }

        int res = 0;

        for (int x : count) {
            res += x;
        }

        return res + n;
    }
}