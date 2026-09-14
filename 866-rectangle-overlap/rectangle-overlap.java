class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Check overlap on the X-axis: 
        // The leftmost right-edge must be strictly greater than the rightmost left-edge
        boolean xOverlap = Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]);
        
        // Check overlap on the Y-axis:
        // The bottommost top-edge must be strictly greater than the topmost bottom-edge
        boolean yOverlap = Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
        
        return xOverlap && yOverlap;
    }
}