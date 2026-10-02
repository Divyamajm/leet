class Solution {
    public int myAtoi(String s) {
        // Step 1: Clean the string and check if it's empty
        s = s.trim();
        if (s.length() == 0) return 0;
        
        int sign = 1;
        int r = 0;
        int total = 0;
        
        // Step 2: Check for a sign EXACTLY ONCE
        if (s.charAt(r) == '-' || s.charAt(r) == '+') {
            if (s.charAt(r) == '-') sign = -1;
            r++; // move past the sign
        }
        
        // Step 3: Now just do the math! (No need to skip zeros manually)
        while (r < s.length()) {
            int digit = s.charAt(r) - '0';
            
            // If it's not a number, stop entirely
            if (digit < 0 || digit > 9) break;
            
            // Catch overflow BEFORE we multiply by 10
            if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            // Mathematically, total * 10 + 0 handles zeros perfectly!
            // E.g., if total is 5, and we see a '0', total becomes 50.
            total = total * 10 + digit;
            r++;
        }
        
        return sign * total;
    }
}