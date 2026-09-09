import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Put words in a HashSet for O(1) fast lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // dp[i] represents if s.substring(0, i) can be segmented into valid words
        boolean[] dp = new boolean[s.length() + 1];
        
        // Base case: an empty string can always be segmented
        dp[0] = true; 
        
        // i represents the end of our current substring
        for (int i = 1; i <= s.length(); i++) {
            // j represents the split point
            for (int j = 0; j < i; j++) {
                // If the first part is valid AND the second part is a dictionary word
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further split points for this 'i'
                }
            }
        }
        
        // Return whether the entire string can be segmented
        return dp[s.length()];
    }
}