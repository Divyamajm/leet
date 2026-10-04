class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        // 1. Create the reversed version of s
        String rev = new StringBuilder(s).reverse().toString();

        // 2. Combine them with a '#' to prevent overlapping
        String combined = s + "#" + rev;

        // 3. Build the KMP LPS array
        int[] lps = new int[combined.length()];
        int j = 0; // length of the previous longest prefix suffix

        for (int i = 1; i < combined.length(); i++) {
            // If characters mismatch, fall back to the previous valid prefix length
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            
            // If they match, extend the prefix length by 1
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            
            // Store the length at the current index
            lps[i] = j;
        }

        // 4. The very last value in the LPS array tells us the length of 
        // the longest palindromic prefix in the original string!
        int longestPalindromicPrefixLength = lps[combined.length() - 1];

        // 5. Grab the leftover characters from the original string
        String leftover = s.substring(longestPalindromicPrefixLength);
        
        // 6. Reverse them and stick them to the front
        String prefixToAdd = new StringBuilder(leftover).reverse().toString();

        return prefixToAdd + s;
    }
}