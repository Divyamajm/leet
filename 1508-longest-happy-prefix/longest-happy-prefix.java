class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        
        // The Longest Prefix Suffix (LPS) array
        int[] lps = new int[n];
        int j = 0; // length of the previous longest prefix suffix
        
        // Build the LPS array for the string
        for (int i = 1; i < n; i++) {
            
            // If the characters don't match, fallback to the previous valid prefix length
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            
            // If the characters match, extend the prefix length by 1
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            
            // Store the length at the current index
            lps[i] = j;
        }
        
        // The last element of the array tells us the length of the longest 
        // prefix that is also a suffix for the entire string.
        int happyPrefixLength = lps[n - 1];
        
        // Return that exact prefix using substring
        return s.substring(0, happyPrefixLength);
    }
}