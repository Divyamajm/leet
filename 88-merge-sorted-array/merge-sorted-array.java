class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] final1=new int[m+nums2.length];
        int i;
        for(i=0;i<m;i++){
            final1[i]=nums1[i];
        }
        for(i=m;i<m+nums2.length;i++){
            final1[i]=nums2[i-m];
        }
        Arrays.sort(final1);
        for(int j=0;j<m+nums2.length;j++){
            nums1[j]=final1[j];
        }
    }
}