class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        // 1. Build the standard LCS DP table
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // 2. Backtrack to construct the Shortest Common Supersequence
        int i = n;
        int j = m;
        StringBuilder sb = new StringBuilder();
        
        while (i > 0 && j > 0) {
            // If characters match, they are part of the LCS. Add once.
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } 
            // If moving UP gave a better LCS, we are skipping a char in str1. 
            // We must add it to our supersequence.
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } 
            // If moving LEFT gave a better LCS, we are skipping a char in str2.
            // We must add it to our supersequence.
            else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        
        // 3. If str2 is exhausted but str1 still has characters left
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        
        // 4. If str1 is exhausted but str2 still has characters left
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }
        
        // Because we walked backward from the end of the strings, 
        // our result is reversed. Reverse it back!
        return sb.reverse().toString();
    }
}