class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n + 1][m + 1];
        
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
        }
        
        // FIXED BASE CASE
        for (int j = 1; j <= m; j++) {
            int flag = 1;
            for (int i = 1; i <= j; i++) {
                if (p.charAt(i - 1) != '*') {
                    flag = 0;
                    break; 
                }
            }
            dp[0][j] = flag;
        }
        
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s.charAt(ind1 - 1) == p.charAt(ind2 - 1) || p.charAt(ind2 - 1) == '?') {
                    dp[ind1][ind2] = dp[ind1 - 1][ind2 - 1];
                } 
                else if (p.charAt(ind2 - 1) == '*') {
                    if (dp[ind1 - 1][ind2] == 1 || dp[ind1][ind2 - 1] == 1) {
                        dp[ind1][ind2] = 1;
                    } else {
                        dp[ind1][ind2] = 0;
                    }
                } 
                else {
                    dp[ind1][ind2] = 0;
                }
            }
        }
        
        int x = dp[n][m];
        if (x == 0) {
            return false;
        }
        return true;
    }
}