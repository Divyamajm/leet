class Solution {
    private int helper(int ind,int buy,int[]prices,int[][] dp){
        if(ind>=prices.length){
            return 0;
        }
        int profit=0;
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        if(buy==1){
            profit=Math.max(-prices[ind]+helper(ind+1,0,prices,dp),helper(ind+1,1,prices,dp));
        }
        else{
            profit=Math.max(prices[ind]+helper(ind+2,1,prices,dp),helper(ind+1,0,prices,dp));
        }
        dp[ind][buy]=profit;
        return dp[ind][buy];
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][]dp=new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,1,prices,dp);
    }
}