class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = n1 + n2;
        
        int p1 = 0; 
        int p2 = 0;
        int prev = 0; 
        int curr = 0;
        
        // We only need to iterate to the middle of the combined logical array
        for (int i = 0; i <= total / 2; i++) {
            prev = curr; // Keep track of the last processed element
            
            // If nums1 has elements left AND (nums2 is exhausted OR nums1's current is smaller)
            if (p1 < n1 && (p2 == n2 || nums1[p1] <= nums2[p2])) {
                curr = nums1[p1];
                p1++;
            } else {
                curr = nums2[p2];
                p2++;
            }
        }
        
        // If total length is odd, the median is the last processed element
        if (total % 2 == 1) {
            return (double) curr;
        } 
        // If total length is even, it's the average of the two middle elements
        else {
            return (prev + curr) / 2.0;
        }
    }
}