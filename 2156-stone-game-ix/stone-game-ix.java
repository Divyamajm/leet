class Solution {
    public boolean stoneGameIX(int[] stones) {
        // Step 1: Create 3 buckets for the remainders
        int[] count = new int[3];
        
        for (int stone : stones) {
            count[stone % 3]++;
        }
        
        // Step 2: Apply the Game Theory logic based on the number of 'mod0' stones
        if (count[0] % 2 == 0) {
            // If mod0 is even, Alice wins if she has at least one 1 and one 2
            return count[1] > 0 && count[2] > 0;
        } else {
            // If mod0 is odd, the turns get flipped. 
            // Alice needs a major majority in one of the remaining buckets to win.
            return Math.abs(count[1] - count[2]) > 2;
        }
    }
}