class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=1;
        int r=arr.length-1;
        int count=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if((arr[mid]-(mid+1))>=k){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }if(arr[0]>k){
            return k;
        }
        return l+k;
    }
}