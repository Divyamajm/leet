import java.util.Arrays;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // Step 1: Create pairs of [value, original_index]
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        // Step 2: Sort the array based on values
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] res = new int[n];
        int i = 0;
        
        // Step 3 & 4: Find groups and place them in sorted original indices
        while (i < n) {
            int j = i + 1;
            
            // Expand the group as long as the difference is within the limit
            while (j < n && pairs[j][0] - pairs[j - 1][0] <= limit) {
                j++;
            }
            
            // Collect all original indices for the current group
            int[] indices = new int[j - i];
            for (int k = i; k < j; k++) {
                indices[k - i] = pairs[k][1];
            }
            
            // Sort the indices so we put the smallest values in the earliest spots
            Arrays.sort(indices);
            
            // Assign the sorted values to the sorted indices in the result array
            for (int k = i; k < j; k++) {
                res[indices[k - i]] = pairs[k][0];
            }
            
            // Move to the next group
            i = j;
        }
        
        return res;
    }
}