import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n - k + 1];
        int x = 0; // index for the result array
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove elements that are no longer in the window (from the FRONT)
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // 2. Remove elements that are smaller than the current element (from the BACK)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // 3. Add the current element's index (to the BACK)
            deque.offerLast(i);
            
            // 4. Record the maximum if our window has reached size k (from the FRONT)
            if (i >= k - 1) {
                arr[x++] = nums[deque.peekFirst()];
            }
        }
        
        return arr;
    }
}