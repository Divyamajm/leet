class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        
        // Step 1: Find the minimum coin to set a safe upper bound for Binary Search
        long minCoin = coins[0];
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }
        
        // Step 2: Precompute the LCM for every possible subset of coins using Bitmasking
        // 1 << n is mathematically 2^n. If we have 3 coins, there are 8 possible subsets.
        long[] lcmArray = new long[1 << n];
        int[] signArray = new int[1 << n];
        
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int setBits = 0; // Counts how many coins are in this specific combination
            
            for (int i = 0; i < n; i++) {
                // If the i-th bit is set to 1, include coins[i] in this subset
                if ((mask & (1 << i)) != 0) {
                    lcm = getLcm(lcm, coins[i]);
                    setBits++;
                }
            }
            
            lcmArray[mask] = lcm;
            // Inclusion-Exclusion Principle: Odd subsets are added (+1), Even subsets are subtracted (-1)
            signArray[mask] = (setBits % 2 == 1) ? 1 : -1;
        }
        
        // Step 3: Binary Search on the Answer
        long low = 1;
        long high = (long) k * minCoin; 
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2; // 'mid' is our guessed amount
            
            // Run the Inclusion-Exclusion math using our precomputed arrays
            long count = 0;
            for (int mask = 1; mask < (1 << n); mask++) {
                count += signArray[mask] * (mid / lcmArray[mask]);
            }
            
            // If the formula says we have 'k' or more multiples, 
            // this guess is valid, but we try to find a smaller one!
            if (count >= k) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; // We need a bigger amount
            }
        }
        
        return ans;
    }
    
    // --- Math Helper Methods ---
    
    // Least Common Multiple
    private long getLcm(long a, long b) {
        // We divide by GCD first to prevent multiplication overflow
        return a * (b / getGcd(a, b)); 
    }
    
    // Greatest Common Divisor (Euclidean Algorithm)
    private long getGcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}