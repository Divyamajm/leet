class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = Arrays.copyOf(nums1, m);
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            nums1[k++] = (copy[i] <= nums2[j]) ? copy[i++] : nums2[j++];
        }
        while (i < m) nums1[k++] = copy[i++];
        while (j < n) nums1[k++] = nums2[j++];
    }
}