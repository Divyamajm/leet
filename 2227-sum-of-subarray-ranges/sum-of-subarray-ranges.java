import java.util.Stack;

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        
        int[] pse = new int[n]; // Previous Smaller Element
        int[] nse = new int[n]; // Next Smaller Element
        int[] pge = new int[n]; // Previous Greater Element
        int[] nge = new int[n]; // Next Greater Element
        
        Stack<Integer> s = new Stack<>();
        
        // 1. Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && nums[s.peek()] >= nums[i]) {
                s.pop();
            }
            pse[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        
        s.clear(); // Reuse the same stack
        
        // 2. Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            // Strict inequality (>) to avoid duplicate counting
            while (!s.isEmpty() && nums[s.peek()] > nums[i]) {
                s.pop();
            }
            nse[i] = s.isEmpty() ? n : s.peek(); // Default is 'n', not -1
            s.push(i);
        }
        
        s.clear();
        
        // 3. Previous Greater Element (PGE)
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                s.pop();
            }
            pge[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        
        s.clear();
        
        // 4. Next Greater Element (NGE)
        for (int i = n - 1; i >= 0; i--) {
            // Strict inequality (<) to avoid duplicate counting
            while (!s.isEmpty() && nums[s.peek()] < nums[i]) {
                s.pop();
            }
            nge[i] = s.isEmpty() ? n : s.peek(); // Default is 'n', not -1
            s.push(i);
        }
        
        // 5. Calculate Total
        long minSum = 0;
        long maxSum = 0;
        
        for (int i = 0; i < n; i++) {
            // Must use long to prevent integer overflow
            long leftMinDist = i - pse[i];
            long rightMinDist = nse[i] - i;
            minSum += (leftMinDist * rightMinDist) * (long) nums[i];
            
            long leftMaxDist = i - pge[i];
            long rightMaxDist = nge[i] - i;
            maxSum += (leftMaxDist * rightMaxDist) * (long) nums[i];
        }
        
        return maxSum - minSum;
    }
}