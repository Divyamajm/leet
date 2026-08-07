class Solution {
    public String smallestNumber(String num, long t) {
        long temp = t;
        int[] req = new int[10];
        
        // 1. FAST-FAIL & PRIME FACTORIZATION
        // Break 't' down into its required prime ingredients: 2, 3, 5, and 7
        for (int p : new int[]{2, 3, 5, 7}) {
            while (temp % p == 0) {
                req[p]++;
                temp /= p;
            }
        }
        
        // If 't' requires any prime larger than 7 (like 11, 13), it's impossible.
        if (temp > 1) {
            return "-1";
        }
        
        // Pre-calculate what prime factors each digit (1-9) provides
        int[][] factors = new int[10][10];
        for (int i = 1; i <= 9; i++) {
            int val = i;
            for (int p : new int[]{2, 3, 5, 7}) {
                while (val % p == 0) {
                    factors[i][p]++;
                    val /= p;
                }
            }
        }

        int n = num.length();
        int[] pref = new int[10];
        int firstZero = n;
        
        // 2. SCAN THE STRING LEFT TO RIGHT
        // Accumulate the prime factors we already have, and find the first '0'
        for (int i = 0; i < n; i++) {
            int d = num.charAt(i) - '0';
            if (d == 0 && firstZero == n) {
                firstZero = i;
            }
            if (d > 0) {
                for (int p : new int[]{2, 3, 5, 7}) {
                    pref[p] += factors[d][p];
                }
            }
        }
        
        // 3. CHECK IF THE ORIGINAL NUMBER ALREADY WORKS
        if (firstZero == n) {
            boolean ok = true;
            for (int p : new int[]{2, 3, 5, 7}) {
                if (pref[p] < req[p]) ok = false;
            }
            if (ok) return num;
        }

        // 4. GREEDY STRING CONSTRUCTION (Right to Left)
        for (int i = n - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            
            // Remove the current digit's factors since we are trying to change it
            if (d > 0) {
                for (int p : new int[]{2, 3, 5, 7}) {
                    pref[p] -= factors[d][p];
                }
            }
            
            // We cannot increment a digit that comes AFTER a zero to fix that earlier zero
            if (i > firstZero) continue;
            
            // Try incrementing the current digit to something larger
            for (int greater = d + 1; greater <= 9; greater++) {
                int[] need = new int[10];
                for (int p : new int[]{2, 3, 5, 7}) {
                    // Calculate how many MORE prime factors we still need
                    need[p] = Math.max(0, req[p] - (pref[p] + factors[greater][p]));
                }
                
                // Get the shortest possible string of digits that provides the missing factors
                String suffix = getMinSuffix(need);
                int spaceLeft = n - 1 - i;
                
                // If the required digits can fit in the available space to the right
                if (suffix.length() <= spaceLeft) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num.substring(0, i));            // Keep the left prefix the same
                    sb.append(greater);                        // Insert the incremented digit
                    
                    int onesCount = spaceLeft - suffix.length();
                    for(int k = 0; k < onesCount; k++) {
                        sb.append('1');                        // Pad any extra space with '1's
                    }
                    sb.append(suffix);                         // Add the required digits at the very end
                    
                    return sb.toString();
                }
            }
        }
        
        // 5. IF WE MUST INCREASE THE STRING LENGTH
        // If no replacement within length 'n' worked, the answer is 1 digit longer
        String suffix = getMinSuffix(req);
        int spaceLeft = n + 1;
        int onesCount = Math.max(0, spaceLeft - suffix.length());
        
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < onesCount; k++) {
            sb.append('1');
        }
        sb.append(suffix);
        
        return sb.toString();
    }
    
    // HELPER: Builds the shortest & smallest possible string of digits from prime factors
    private String getMinSuffix(int[] req) {
        int r2 = req[2], r3 = req[3], r5 = req[5], r7 = req[7];
        
        // Compress primes to save space (e.g., three 2s become one 8)
        int c8 = r2 / 3; r2 %= 3; 
        int c9 = r3 / 2; r3 %= 2; 
        int c4 = r2 / 2; r2 %= 2; 
        int c6 = 0;
        
        // Tie-breaker optimization for lexicographically smaller combinations
        if (r2 == 1 && r3 == 1) { 
            c6 = 1; r2 = 0; r3 = 0;  // Use '6' instead of '2' and '3'
        }
        if (r3 == 1 && c4 == 1) { 
            r2 = 1; c6 = 1; r3 = 0; c4 = 0; // Use '2' and '6' instead of '3' and '4'
        }
        
        // Append digits in ascending order to ensure it is lexicographically smallest
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r2; i++) sb.append('2');
        for(int i = 0; i < r3; i++) sb.append('3');
        for(int i = 0; i < c4; i++) sb.append('4');
        for(int i = 0; i < r5; i++) sb.append('5');
        for(int i = 0; i < c6; i++) sb.append('6');
        for(int i = 0; i < r7; i++) sb.append('7');
        for(int i = 0; i < c8; i++) sb.append('8');
        for(int i = 0; i < c9; i++) sb.append('9');
        
        return sb.toString();
    }
}