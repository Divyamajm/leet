class Solution {
    private int helper(int index,int amount,int[]coins,int[][]dp){
        if(index==0){
            if(amount%coins[0]==0){
                return 1;
            }
            return 0;
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int l=0+helper(index-1,amount,coins,dp);
        int r=0;
        if(coins[index]<=amount){r=helper(index,amount-coins[index],coins,dp);}
        dp[index][amount]=l+r;
        return dp[index][amount];
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][2*amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(n-1,amount,coins,dp);
    }
}