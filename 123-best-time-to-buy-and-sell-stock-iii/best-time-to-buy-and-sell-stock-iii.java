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
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j][0]=0;
            }
        }
        for(int j=0;j<2;j++){
            for(int k=0;k<3;k++){
                dp[0][j][k]=0;
            }
        }
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<2;buy++){
                for(int cap=1;cap<3;cap++){
                    int profit=0;
                if(buy==1){
                    profit=Math.max(-prices[ind]+dp[ind+1][0][cap],dp[ind+1][1][cap]);
                }
                else{
                    profit=Math.max(prices[ind]+dp[ind+1][1][cap-1],dp[ind+1][0][cap]);
                }
                dp[ind][buy][cap]=profit;
                // return dp[ind][buy][cap];
                }
            }
        }
        return dp[0][1][2];
    }
}