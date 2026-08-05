import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Step 1: Build the adjacency list for the directed graph
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : invocations) {
            adj[edge[0]].add(edge[1]);
        }
        
        // Step 2: Use BFS to find all suspicious methods
        boolean[] isSuspicious = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(k);
        isSuspicious[k] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : adj[curr]) {
                if (!isSuspicious[next]) {
                    isSuspicious[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        // Step 3: Check if any non-suspicious method invokes a suspicious method
        boolean canRemove = true;
        for (int[] edge : invocations) {
            int u = edge[0]; // caller
            int v = edge[1]; // callee
            
            if (!isSuspicious[u] && isSuspicious[v]) {
                canRemove = false;
                break;
            }
        }
        
        // Step 4: Build and return the final list
        List<Integer> result = new ArrayList<>();
        if (canRemove) {
            for (int i = 0; i < n; i++) {
                if (!isSuspicious[i]) {
                    result.add(i);
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
        }
        
        return result;
    }
}