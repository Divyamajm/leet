class Solution {
    public int longestSubsequence(int[] nums) {
        int xorSum = 0;
        int zeroCount = 0;
        
        // 1. Get the total XOR and count the zeroes
        for (int num : nums) {
            xorSum ^= num;
            if (num == 0) {
                zeroCount++;
            }
        }
        
        // Case 1: Total XOR is already non-zero. Take everything!
        if (xorSum != 0) {
            return nums.length;
        }
        
        // Case 3: The array is literally nothing but zeroes.
        if (zeroCount == nums.length) {
            return 0;
        }
        
        // Case 2: Total XOR is 0. Just throw away one non-zero number.
        return nums.length - 1;
    }
}