class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length-1;
        int n2=nums2.length-1;
        int cnt=0;
        int ind2=(nums1.length+nums2.length)/2;
        int ind1=ind2-1;
        int first=-1;
        int second=-1;
        int l=0;
        int r=0;
        while(l<=n1&&r<=n2){
            if(nums1[l]<=nums2[r]){
                if(cnt==ind1){
                    first=nums1[l];
                }
                if(cnt==ind2){
                    second=nums1[l];
                }
                l++;
                cnt++;
            }
            else{
                if(cnt==ind1){
                    first=nums2[r];
                }
                if(cnt==ind2){
                    second=nums2[r];
                }
                r++;
                cnt++;
            }
        }
        while(l<=n1){
            if(cnt==ind1){
                first=nums1[l];
            }
            if(cnt==ind2){
                second=nums1[l];
            }
            l++;
            cnt++;
        }
        while(r<=n2){
            if(cnt==ind1){
                first=nums2[r];
            }
            if(cnt==ind2){
                second=nums2[r];
            }
            r++;
            cnt++;
        }
        if((nums1.length+nums2.length)%2==0){
            return (double)(first+second)/2;
        }
        return (double)second;
    }
}