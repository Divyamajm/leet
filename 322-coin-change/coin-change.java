class Solution {
    private int helper(int index,int[]coins,int amount,int[][] dp){
        if(index==0){
            if(amount%coins[index]==0){
                return amount/coins[index];
            }
            return (int)1e9;
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int l=0+helper(index-1,coins,amount,dp);
        int r=Integer.MAX_VALUE;
        if(coins[index]<=amount){
            r=1+helper(index,coins,amount-coins[index],dp);
        }
        dp[index][amount]=Math.min(r,l);
        return dp[index][amount];
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        // int x=helper(n-1,coins,amount,dp);
        // if(x>=(int)1e9){
        //     return -1;
        // }
        for(int target=0;target<=amount;target++){
            if(target%coins[0]==0){
                dp[0][target]=target/coins[0];
            }
            else{
                dp[0][target]=(int)1e9;
            }
        }
        for(int i=1;i<n;i++){
            for(int target=0;target<=amount;target++){
                int l=0+dp[i-1][target];
                int r=Integer.MAX_VALUE;
                if(coins[i]<=target){
                    r=1+dp[i][target-coins[i]];
                }
                dp[i][target]=Math.min(r,l);
                // return dp[index][amount];
            }
        }
        if(dp[n-1][amount]==(int)1e9){
            return -1;
        }
        return dp[n-1][amount];
    }
}