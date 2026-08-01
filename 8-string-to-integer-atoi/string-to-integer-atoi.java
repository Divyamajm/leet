class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        
        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // If the string is empty or only contains spaces
        if (i == n) {
            return 0;
        }
        
        // Step 2: Determine the sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Step 3: Process digits and check for overflow
        int result = 0;
        int limit = Integer.MAX_VALUE / 10; 
        
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Step 4: Overflow/Underflow check
            // We check if multiplying by 10 will push us out of 32-bit bounds
            if (result > limit || (result == limit && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
}