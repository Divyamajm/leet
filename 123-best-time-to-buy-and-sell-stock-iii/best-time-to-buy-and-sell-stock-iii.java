class Solution {
    private int helper(int ind,int buy,int[] prices,int cap,int[][][] dp){
        if(cap==0){
            return 0;
        }
        if(ind==prices.length){
            return 0;
        }
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[ind]+helper(ind+1,0,prices,cap,dp),helper(ind+1,1,prices,cap,dp));
        }
        else{
            profit=Math.max(prices[ind]+helper(ind+1,1,prices,cap-1,dp),helper(ind+1,0,prices,cap,dp));
        }
        dp[ind][buy][cap]=profit;
        return dp[ind][buy][cap];
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][]dp=new int[n+1][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return helper(0,1,prices,2,dp);
    }
}