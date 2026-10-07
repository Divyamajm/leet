class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    public int atMost(int[] nums,int k){
        int l=0;
        int r=0;
        int count=0;
        int sum=0;
        int n=nums.length;
        while(r<n){
            int rchar=nums[r];
            if(rchar%2==1){
                sum++;
            }
            // if(sum<=k){
            //         count+=r-l+1;
            //     }
            while(sum>k){
                if(nums[l]%2==1){
                    sum--;
                }
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}