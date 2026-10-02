class Solution {
    // 1. Using a switch statement is cleaner and slightly faster
    public int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0; // Keep track of the last number we looked at
        
        // Loop from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = value(s.charAt(i));
            
            // 2. Compare with prevValue instead of looking ahead in the string
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            
            // Update prevValue for the next iteration
            prevValue = currentValue;
        }
        
        return total;
    }
}