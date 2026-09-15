class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        // dp[i] stores the max number of palindromes in the substring s[0...i-1]
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // By default, we don't form a new palindrome ending at i-1
            dp[i] = dp[i - 1];
            
            // Check if the last k characters form a palindrome
            if (i >= k) {
                if (isPalindrome(s, i - k, i - 1)) {
                    dp[i] = Math.max(dp[i], dp[i - k] + 1);
                }
            }
            
            // Check if the last k + 1 characters form a palindrome
            if (i >= k + 1) {
                if (isPalindrome(s, i - k - 1, i - 1)) {
                    dp[i] = Math.max(dp[i], dp[i - k - 1] + 1);
                }
            }
        }
        
        return dp[n];
    }
    
    // Helper function to check if a substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}