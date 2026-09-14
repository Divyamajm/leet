class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int min1=Math.min(rec1[0],rec1[2]);
        int max1=Math.max(rec1[0],rec1[2]);
        int min2=Math.min(rec2[0],rec2[2]);
        int max2=Math.max(rec2[0],rec2[2]);
        
        int Min1=Math.min(rec1[1],rec1[3]);
        int Max1=Math.max(rec1[1],rec1[3]);
        int Min2=Math.min(rec2[1],rec2[3]);
        int Max2=Math.max(rec2[1],rec2[3]);
        
        // FIX 1: Changed min2 > min1 to max2 > min1 to handle the "engulfing" case
        // FIX 2: Combined X and Y checks with && because BOTH must overlap
        if ((min2 < max1 && max2 > min1) && (Min2 < Max1 && Max2 > Min1)) {
            return true;
        }
        
        return false;
    }
}