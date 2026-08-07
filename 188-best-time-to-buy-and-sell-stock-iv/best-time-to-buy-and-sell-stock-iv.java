class Solution {
    private int helper(int ind,int buy,int cap,int[] prices,int[][][] dp){
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
            profit=Math.max(-prices[ind]+helper(ind+1,0,cap,prices,dp),helper(ind+1,1,cap,prices,dp));
        }
        else{
            profit=Math.max(prices[ind]+helper(ind+1,1,cap-1,prices,dp),helper(ind+1,0,cap,prices,dp));
        }
        dp[ind][buy][cap]=profit;
        return dp[ind][buy][cap];
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                for(int cap=0;cap<=k;cap++){
                    dp[i][j][cap]=-1;
                }
            }
        }
        return helper(0,1,k,prices,dp);
    }
}