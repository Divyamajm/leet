class Solution {
    private int helper(int ind,int buy,int fee,int[] prices,int[][]dp){
        if(ind==prices.length){
            return 0;
        }
        int profit=0;
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        if(buy==1){
            profit=Math.max(-fee-prices[ind]+helper(ind+1,0,fee,prices,dp),helper(ind+1,1,fee,prices,dp));
        }
        else{
            profit=Math.max(prices[ind]+helper(ind+1,1,fee,prices,dp),helper(ind+1,0,fee,prices,dp));
        }
        dp[ind][buy]=profit;
        return dp[ind][buy];
    }
    public int maxProfit(int[] prices, int fee) {
        int[][]dp=new int[prices.length][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,1,fee,prices,dp);
    }
}