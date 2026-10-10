class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int left = 0;
        int right = n - 1;
        
        while (left <= right) {
            int midCol = left + (right - left) / 2;
            
            // Find the maximum element in the current middle column
            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }
            
            // Check left and right neighbors (with boundary checks)
            boolean isLeftGreater = (midCol - 1 >= 0) && (mat[maxRow][midCol - 1] > mat[maxRow][midCol]);
            boolean isRightGreater = (midCol + 1 < n) && (mat[maxRow][midCol + 1] > mat[maxRow][midCol]);
            
            if (!isLeftGreater && !isRightGreater) {
                return new int[]{maxRow, midCol}; // Found the peak
            } else if (isRightGreater) {
                left = midCol + 1; // Move to the right half
            } else {
                right = midCol - 1; // Move to the left half
            }
        }
        
        return new int[]{-1, -1};
    }
}