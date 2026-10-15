import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;
        
        // Build the histogram row by row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0; // Reset height if we hit a '0'
                }
            }
            // Calculate the largest rectangle for the current row's histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }
    
    // Optimized 1-Pass Histogram logic
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        
        // Iterate up to n (inclusive) to act as a final right boundary (height 0)
        for (int i = 0; i <= n; i++) {
            // Force remaining elements in the stack to pop at the end by using height 0
            int currentHeight = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // The popped element is the minimum height of our rectangle
                int h = heights[stack.pop()];
                
                // The width is the distance between the current index (NSE) 
                // and the new top of the stack (PSE)
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                maxArea = Math.max(maxArea, h * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}