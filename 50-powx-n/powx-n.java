class Solution {
    public double solve(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        
        double half = solve(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        }
        return half * half * x;
    }
    
    public double myPow(double x, int n) {
        long N = n;
        
        // Make N positive, but DO NOT modify x yet!
        if (N < 0) {
            N = -N;
        }
        
        // Calculate x^N
        double ans = solve(x, N);
        
        // If the original power was negative, invert the final result
        if (n < 0) {
            return 1.0 / ans;
        }
        
        return ans;
    }
}