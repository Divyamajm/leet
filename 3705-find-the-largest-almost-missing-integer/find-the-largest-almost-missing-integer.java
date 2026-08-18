import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int largestInteger(int[] nums, int k) {
        // Map to store the number of size-k subarrays each integer appears in
        Map<Integer, Integer> subarrayCounts = new HashMap<>();
        int n = nums.length;
        
        // Iterate through all sliding windows of size k
        for (int i = 0; i <= n - k; i++) {
            // Use a Set to ensure we only count an element once per subarray
            Set<Integer> currentSubarray = new HashSet<>();
            
            for (int j = i; j < i + k; j++) {
                currentSubarray.add(nums[j]);
            }
            
            // Increment the frequency map for each unique number in this window
            for (int num : currentSubarray) {
                subarrayCounts.put(num, subarrayCounts.getOrDefault(num, 0) + 1);
            }
        }
        
        int largestAlmostMissing = -1;
        
        // Iterate through the map to find the maximum number with a count of exactly 1
        for (Map.Entry<Integer, Integer> entry : subarrayCounts.entrySet()) {
            if (entry.getValue() == 1) {
                largestAlmostMissing = Math.max(largestAlmostMissing, entry.getKey());
            }
        }
        
        return largestAlmostMissing;
    }
}