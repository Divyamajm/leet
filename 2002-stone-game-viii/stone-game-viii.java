class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        
        // 1. Calculate Prefix Sums
        int[] prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }
        
        // 2. Base case: If you reach the very end, you must take the last stone.
        // Your score difference is simply the prefix sum at the end.
        int dp = prefix[n - 1]; 
        
        // 3. Work backwards from the second-to-last stone down to index 1.
        // (We stop at 1 because the rules state x > 1, meaning you must take at least 2 stones)
        for (int i = n - 2; i >= 1; i--) {
            // dp represents dp[i+1] from the previous iteration
            // We choose the max of taking this index or skipping it
            dp = Math.max(dp, prefix[i] - dp);
        }
        
        return dp;
    }
}