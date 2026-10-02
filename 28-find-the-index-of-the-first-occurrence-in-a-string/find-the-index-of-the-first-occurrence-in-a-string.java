class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        // Edge case: empty needle is always found at index 0
        if (m == 0) return 0;
        
        // Loop through the haystack (<= is important!)
        for (int i = 0; i <= n - m; i++) {
            
            // Assume we found it, until proven wrong
            boolean match = true;
            
            // Check each character of the needle
            for (int j = 0; j < m; j++) {
                
                // Compare haystack's character to needle's character
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false; // Mismatch found!
                    break;         // Stop checking this word immediately
                }
            }
            
            // If the inner loop finished and match is still true, we found it!
            if (match) {
                return i;
            }
        }
        
        return -1;
    }
}