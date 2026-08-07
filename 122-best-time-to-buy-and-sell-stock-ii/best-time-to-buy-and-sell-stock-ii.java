class Solution {
    private int helper(int ind,int buy,int[] prices,int n,int[][]dp){
        if(ind==n){
            return 0;
        }
        int profit=0;
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        if(buy==1){
            dp[ind][buy]=Math.max(-prices[ind]+helper(ind+1,0,prices,n,dp),helper(ind+1,1,prices,n,dp));
        }
        else{
            dp[ind][buy]=Math.max(prices[ind]+helper(ind+1,1,prices,n,dp),helper(ind+1,0,prices,n,dp));
        }
        return dp[ind][buy];
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][]dp=new int[n+1][2];
        // for(int[]row:dp){
        //     Arrays.fill(row,-1);
        // }
        dp[n][0]=0;
        dp[n][1]=0;
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<2;buy++){
                int profit=0;
                if(buy==1){
                    profit=Math.max(-prices[ind]+dp[ind+1][0],dp[ind+1][1]);
                }
                else{
                    profit=Math.max(prices[ind]+dp[ind+1][1],dp[ind+1][0]);
                }
                dp[ind][buy]=profit;
            }
        }
        return dp[0][1];
    }
}