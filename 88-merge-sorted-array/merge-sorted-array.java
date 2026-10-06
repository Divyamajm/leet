class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for nums1, nums2, and the end of the merged array
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        
        // While there are still elements to compare in both arrays
        while (p1 >= 0 && p2 >= 0) {
            // Pick the LARGEST element and put it at the back
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--; // Move the insertion pointer backwards
        }
        
        // If there are leftover elements in nums2, copy them over.
        // (If there are leftover elements in nums1, they are already in the right place!)
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}