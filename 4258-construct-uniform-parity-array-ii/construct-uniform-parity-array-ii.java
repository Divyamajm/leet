class Solution {
    // FIX: Changed method name to uniformArray
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        boolean hasOdd = false;
        
        // Find the minimum value and check if any odd number exists
        for (int num : nums1) {
            if (num < minVal) {
                minVal = num;
            }
            if (num % 2 != 0) {
                hasOdd = true;
            }
        }
        
        // If the smallest number is odd, we can always make everything odd.
        if (minVal % 2 != 0) {
            return true;
        } 
        
        // If the smallest number is even, we can only succeed if the ENTIRE array is already even.
        // If there is even a single odd number, return false.
        return !hasOdd;
    }
}