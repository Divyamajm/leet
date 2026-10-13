import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        // 1. Take absolute values (Your exact method!)
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = nums[i] * (-1);
            }
        }
        
        // 2. Sort the array so the smallest values are at the beginning
        Arrays.sort(nums);
        
        long total = 0; // Fixed: Must be long to prevent overflow
        
        // In an alternating sequence, exactly floor(n/2) elements are subtracted.
        int negativeCount = n / 2;
        
        // 3. Subtract the smallest squares, add the largest squares
        for (int i = 0; i < n; i++) {
            // Fixed: Cast to long BEFORE squaring to prevent overflow!
            long square = (long) nums[i] * nums[i]; 
            
            if (i < negativeCount) {
                total -= square;
            } else {
                total += square;
            }
        }
        
        return total;
    }
}