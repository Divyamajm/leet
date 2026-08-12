class Solution {
    private boolean helper(int mid,int[] bloomDay,int m,int k){
        int count=0;
        int total=0;
        for(int i=0;i<bloomDay.length;i++){
            if(mid>=bloomDay[i]){
                count++;
            }
            else{
                total+=count/k;
                count=0;
            }
        }
        total+=count/k;
        if(total>=m){
            return true;
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int l=min;
        int r=max;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            System.out.print(mid);
            boolean x=helper(mid,bloomDay,m,k);
            // System.out.print(x);
            if(x==true){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }return ans;
    }
}