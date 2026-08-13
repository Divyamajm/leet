class Solution {
    
    private int helper(int mid, int[][] mat) {
        int n = mat.length;
        // int m = mat[0].length; // You don't actually need 'm' in here
        int ind = -1;
        int maxValue = -1;
        
        // FIX 1: Iterate up to 'n' (rows), not 'm'
        for (int i = 0; i < n; i++) {
            if (mat[i][mid] > maxValue) {
                ind = i;
                maxValue = mat[i][mid];
            }
        }
        return ind;
    }
    
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int l = 0;
        int r = m - 1;
        int[] result = new int[2];
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int peak = helper(mid, mat);
            
            int l1 = -1;
            int r1 = -1;
            
            // FIX 3: Must be >= 0 to include the 0th column
            if (mid - 1 >= 0) {
                // FIX 2: Assign to l1, NOT the binary search pointer 'l'
                l1 = mat[peak][mid - 1]; 
            }
            if (mid + 1 < m) {
                r1 = mat[peak][mid + 1];
            }
            
            if (mat[peak][mid] > l1 && mat[peak][mid] > r1) {
                result[0] = peak;
                result[1] = mid;
                return result;
            } else if (mat[peak][mid] < l1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return new int[]{-1, -1};
    }
}