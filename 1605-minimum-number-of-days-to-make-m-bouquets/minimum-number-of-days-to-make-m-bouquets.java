class Solution {
    public int bloom(int[] bloomDay,int m,int k,int mid){
        int n=bloomDay.length;
        int adj=0;
        int total=0;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=mid){
                // count++;
                adj++;
                if(adj>=k){
                    total++;
                    adj=0;
                }
            }
            else{
                adj=0;
            }
        }
        return total;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int result=-1;
        int n=bloomDay.length;
        for(int i=0;i<n;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int l=min;
        int r=max;
        while(l<=r){
            int mid=l+(r-l)/2;
            int ans=bloom(bloomDay,m,k,mid);
            if(ans>=m){
                r=mid-1;
                result=mid;
            }
            else{
                l=mid+1;
            }
        }
        return result;
    }
}