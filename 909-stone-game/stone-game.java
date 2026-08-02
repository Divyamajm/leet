class Solution {
    private int helper(int left,int right,int[] piles,int[][] dp){
        if(left==right){
            return dp[left][right];
        }
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        int l=piles[left]+helper(left+1,right,piles,dp);
        int r=piles[right]+helper(left,right-1,piles,dp);
        dp[left][right]=Math.max(l,r);
        return dp[left][right];
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int[][] dp=new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int c=helper(0,n-1,piles,dp);
        return c>=0;
    }
}