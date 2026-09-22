class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        // If haystack is shorter than needle, it's impossible
        if (n < m) return -1;
        
        // Only loop up to the point where the remaining characters 
        // are exactly the length of the needle
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            // Check character by character
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            // If we matched all characters in the needle
            if (j == m) {
                return i;
            }
        }
        
        return -1;
    }
}