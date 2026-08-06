class Solution {
    private int helper(int ind1,int ind2,String word1,String word2,int[][]dp){
        if(ind1==0){
            return ind2;
        }
        if(ind2==0){
            return ind1;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(word1.charAt(ind1-1)==word2.charAt(ind2-1)){
            // return 
            dp[ind1][ind2]=helper(ind1-1,ind2-1,word1,word2,dp);
            return dp[ind1][ind2];
        }
        else{
            dp[ind1][ind2]=1+Math.min(helper(ind1-1,ind2,word1,word2,dp),Math.min(helper(ind1,ind2-1,word1,word2,dp),helper(ind1-1,ind2-1,word1,word2,dp)));
            return dp[ind1][ind2];
        }
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];
        for(int[]row: dp){
            Arrays.fill(row,-1);
        }
        return helper(n,m,word1,word2,dp);
    }
}