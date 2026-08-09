class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // Suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        return solve(0, 1, piles);
    }

    private int solve(int i, int M, int[] piles) {

        // All piles are taken
        if (i >= n) {
            return 0;
        }

        // Can take all remaining piles
        if (2 * M >= n - i) {
            return suffix[i];
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int best = 0;

        // Try every possible X
        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int newM = Math.max(M, X);

            // Stones current player gets
            // = total remaining - opponent's best
            int current =
                suffix[i] - solve(i + X, newM, piles);

            best = Math.max(best, current);
        }

        return dp[i][M] = best;
    }
}