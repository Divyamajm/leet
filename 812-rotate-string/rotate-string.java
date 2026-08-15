class Solution {
    // 1. Made this void. It modifies the array in-place, no need to return a String yet.
    private void reverse(int start, int end, char[] s) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        
        // If they are exactly the same from the start (0 rotations)
        if(s.equals(goal)) {
            return true;
        }
        
        char[] s2 = s.toCharArray();
        int n = s2.length;
        
        // Rotate the array by 1 character, N times.
        for(int i = 0; i < n; i++) {
            
            // The Triple Reversal formula to shift left by 1
            // reverse(0, 0, s2);          // Reverse the first chunk (size 1)
            reverse(1, n - 1, s2);      // Reverse the remaining chunk
            reverse(0, n - 1, s2);      // Reverse the whole array
            
            // Convert to string and safely compare the TEXT, not the memory address
            if(String.valueOf(s2).equals(goal)) {
                return true;
            }
        }
        
        return false;
    }
}