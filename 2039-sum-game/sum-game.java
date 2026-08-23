class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sum1 = 0, sum2 = 0;
        int q1 = 0, q2 = 0;
        
        // 1. Calculate sums and '?' counts for the left half
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                q1++;
            } else {
                sum1 += num.charAt(i) - '0';
            }
        }
        
        // 2. Calculate sums and '?' counts for the right half
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                q2++;
            } else {
                sum2 += num.charAt(i) - '0';
            }
        }
        
        // 3. If total '?' is odd, Alice gets the last move and wins guaranteed
        if ((q1 + q2) % 2 != 0) {
            return true;
        }
        
        // 4. For Bob to win, the difference in sums must exactly equal 
        // the difference in '?' pairs multiplied by 9. 
        return (sum1 - sum2) != (q2 - q1) / 2 * 9;
    }
}