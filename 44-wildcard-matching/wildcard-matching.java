class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n + 1][m + 1];
        
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
        }
        
        // FIXED: Loop must iterate up to 'm' (pattern length) and update row 0 (dp[0][ind2])
        for (int ind2 = 1; ind2 <= m; ind2++) {
            int flag = 1;
            for (int i = 1; i <= ind2; i++) {
                if (p.charAt(i - 1) != '*') {
                    flag = 0;
                    break;
                }
            }
            dp[0][ind2] = flag;
        }
        
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                
                if (s.charAt(ind1 - 1) == p.charAt(ind2 - 1) || p.charAt(ind2 - 1) == '?') {
                    dp[ind1][ind2] = dp[ind1 - 1][ind2 - 1];
                }
                // FIXED: Must use 'else if' to prevent overwriting
                else if (p.charAt(ind2 - 1) == '*') { 
                    if (dp[ind1 - 1][ind2] == 1 || dp[ind1][ind2 - 1] == 1) {
                        dp[ind1][ind2] = 1;
                    } else {
                        dp[ind1][ind2] = 0;
                    }
                }
                // FIXED: Must use 'else' to prevent overwriting
                else { 
                    dp[ind1][ind2] = 0;
                }
            }
        }
        
        return dp[n][m] == 1;
    }
}