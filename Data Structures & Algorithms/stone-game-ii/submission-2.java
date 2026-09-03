class Solution {
    public int stoneGameII(int[] piles) {
        Integer[][] dp = new Integer[piles.length][piles.length + 1];
        return helper(piles, 0, 1, dp);
    }

    public int helper(int[] piles, int i, int M, Integer[][] dp) {
        if (i >= piles.length) {
            return 0;
        }

        if (dp[i][M] != null) {
            return dp[i][M];
        }

        int remaining = 0;

        for (int j = i; j < piles.length; j++) {
            remaining += piles[j];
        }

        int total = 0;
        int best = 0;

        for (int X = 1; X <= 2 * M && i + X <= piles.length; X++) {
            total += piles[i + X - 1];
            int opponent = helper(piles, i + X, Math.max(M, X), dp);

            int stonesLeft = remaining - total; // after curr player
            int current = total + (stonesLeft - opponent); // now + future for curr player

            best = Math.max(best, current);
        }
        dp[i][M] = best;

        return best;
    }
}