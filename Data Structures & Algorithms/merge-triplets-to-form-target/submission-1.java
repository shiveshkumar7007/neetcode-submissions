class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] mx = new int[3];

        for (int[] t : triplets) {
            if (t[0] > target[0] ||
                t[1] > target[1] ||
                t[2] > target[2]) {
                continue;
            }

            mx[0] = Math.max(mx[0], t[0]);
            mx[1] = Math.max(mx[1], t[1]);
            mx[2] = Math.max(mx[2], t[2]);
        }

        return mx[0] == target[0] &&
               mx[1] == target[1] &&
               mx[2] == target[2];
    }
}