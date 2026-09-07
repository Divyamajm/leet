class Solution {
    // The modulo value required by the problem to prevent overflow
    public long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        // Calculate how many even and odd positions exist
        long evens = (n + 1) / 2; // Ceil division (e.g., if n=5, evens=3)
        long odds = n / 2;        // Floor division (e.g., if n=5, odds=2)
        
        // Use our recursive power function!
        long firstPart = power(5, evens);
        long secondPart = power(4, odds);
        
        // Multiply them together and apply modulo one last time
        return (int)((firstPart * secondPart) % MOD);
    }

    // The exact same O(log n) recursion pattern we used in myPow
    private long power(long x, long n) {
        if (n == 0) return 1;
        
        long half = power(x, n / 2);
        long halfSquared = (half * half) % MOD;
        
        // If power is even: (half * half)
        if (n % 2 == 0) {
            return halfSquared;
        } 
        // If power is odd: (half * half * x)
        else {
            return (halfSquared * x) % MOD;
        }
    }
}