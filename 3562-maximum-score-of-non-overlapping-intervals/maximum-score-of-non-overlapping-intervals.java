import java.util.*;

class Solution {
    
    // Custom class to store interval data along with its original index
    class Interval {
        int l, r, index;
        long weight;
        
        Interval(int l, int r, long weight, int index) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.index = index;
        }
    }
    
    // DP State storing the maximum weight and the sorted chosen indices
    class State {
        long weight;
        int[] indices;
        
        State(long weight, int[] indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }
    
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervals.get(i);
            // interval.get(0) = l, interval.get(1) = r, interval.get(2) = weight
            arr[i] = new Interval(interval.get(0), interval.get(1), interval.get(2), i);
        }
        
        // Sort intervals by their start times.
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            if (a.r != b.r) return Integer.compare(a.r, b.r);
            return Integer.compare(a.index, b.index);
        });
        
        // dp[i][k] = best state using a suffix of intervals starting at i, picking AT MOST k intervals
        State[][] dp = new State[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0L, new int[0]);
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            // Find the index of the next non-overlapping interval using Binary Search
            int next_j = findNext(arr, i);
            
            for (int k = 1; k <= 4; k++) {
                // Option 1: Skip the current interval
                State skip = dp[i + 1][k];
                
                // Option 2: Take the current interval
                long takeWeight = arr[i].weight + dp[next_j][k - 1].weight;
                int[] prevIdx = dp[next_j][k - 1].indices;
                int[] takeIdx = new int[prevIdx.length + 1];
                
                // Copy previous choices, add current, and sort to maintain the lexicographical order correctly
                System.arraycopy(prevIdx, 0, takeIdx, 0, prevIdx.length);
                takeIdx[prevIdx.length] = arr[i].index;
                Arrays.sort(takeIdx);
                
                State take = new State(takeWeight, takeIdx);
                
                // Determine the best choice
                dp[i][k] = best(skip, take);
            }
        }
        
        return dp[0][4].indices;
    }
    
    // Binary search to find the first interval that starts strictly after arr[i] ends
    private int findNext(Interval[] arr, int i) {
        int low = i + 1, high = arr.length - 1;
        int ans = arr.length;
        int target = arr[i].r;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].l > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    // Selects the better state. Evaluates strictly by maximum weight, breaking ties lexicographically
    private State best(State a, State b) {
        if (a.weight > b.weight) return a;
        if (b.weight > a.weight) return b;
        
        // If weights are equal, compare arrays lexicographically
        for (int i = 0; i < Math.min(a.indices.length, b.indices.length); i++) {
            if (a.indices[i] < b.indices[i]) return a;
            if (b.indices[i] < a.indices[i]) return b;
        }
        
        // If they share exactly the same prefix, the shorter one is lexicographically smaller
        if (a.indices.length < b.indices.length) return a;
        if (b.indices.length < a.indices.length) return b;
        
        return a; // Identical
    }
}