class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String bestAns = "";
        int left = 0;
        int onesCount = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Expand the window by including the right character
            if (s.charAt(right) == '1') {
                onesCount++;
            }
            
            // When we have exactly k ones, we evaluate the substring and shrink from the left
            while (onesCount == k) {
                String currentSub = s.substring(left, right + 1);
                
                // Update bestAns if it's empty, shorter, or lexicographically smaller
                if (bestAns.isEmpty() || 
                    currentSub.length() < bestAns.length() || 
                    (currentSub.length() == bestAns.length() && currentSub.compareTo(bestAns) < 0)) {
                    
                    bestAns = currentSub;
                }
                
                // Shrink the window
                if (s.charAt(left) == '1') {
                    onesCount--;
                }
                left++;
            }
        }
        
        return bestAns;
    }
}