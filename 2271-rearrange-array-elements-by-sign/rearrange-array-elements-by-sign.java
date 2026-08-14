class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Create an empty array of the same size
        int[] ans = new int[nums.length];
        
        // Pointers for the next available slots
        int posIndex = 0; // Positives go in even indices (0, 2, 4...)
        int negIndex = 1; // Negatives go in odd indices (1, 3, 5...)
        
        // Walk through the original array exactly once
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i]; // Drop positive number in its slot
                posIndex += 2;           // Move to the next even slot
            } else {
                ans[negIndex] = nums[i]; // Drop negative number in its slot
                negIndex += 2;           // Move to the next odd slot
            }
        }
        
        return ans;
    }
}