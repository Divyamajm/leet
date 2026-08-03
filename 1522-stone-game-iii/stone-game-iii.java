class Solution {
    private int helper(int index, int[] stoneValue, Integer[] dp) {
        // Base case: If we have reached the end of the array, there are no stones left to score.
        if (index == stoneValue.length) {
            return 0;
        }
        
        // Memoization: If we have already calculated the best score for this index, return it.
        if (dp[index] != null) {
            return dp[index];
        }
        
        int maxRelativeScore = Integer.MIN_VALUE;
        int currentSum = 0;
        
        // We can take 1, 2, or 3 stones. We loop up to 3 times.
        for (int i = 0; i < 3; i++) {
            // Make sure we don't try to grab stones that don't exist (Out of Bounds check)
            if (index + i < stoneValue.length) {
                
                // Add the physical stone(s) to our current grab
                currentSum += stoneValue[index + i];
                
                // Minimax Logic: Our current grab MINUS the best the opponent can do from the remaining stones
                int currentOptionScore = currentSum - helper(index + i + 1, stoneValue, dp);
                
                // Keep track of whichever grab (1, 2, or 3 stones) gives us the best relative score
                maxRelativeScore = Math.max(maxRelativeScore, currentOptionScore);
            }
        }
        
        // Save the best result in our DP array before returning
        dp[index] = maxRelativeScore;
        return dp[index];
    }
    
    public String stoneGameIII(int[] stoneValue) {
        // We use an Integer[] array instead of int[] because relative scores can be negative.
        // Integer[] initializes with 'null', making it easy to check if a state is uncalculated.
        Integer[] dp = new Integer[stoneValue.length];
        
        // Alice starts at index 0. The result is Alice's final relative score.
        int x = helper(0, stoneValue, dp);
        
        // Fixed winner logic: Positive means Alice scored more, Negative means Bob scored more.
        if (x > 0) {
            return "Alice";
        } else if (x < 0) {
            return "Bob";
        }
        return "Tie";
    }
}