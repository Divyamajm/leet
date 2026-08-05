class Solution {
    private int helper(int ind1,int ind2,String word1, String word2,int[][] dp){
        if(ind1==0||ind2==0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(word1.charAt(ind1-1)==word2.charAt(ind2-1)){
            dp[ind1][ind2]=1+helper(ind1-1,ind2-1,word1,word2,dp);
            return dp[ind1][ind2];
        }
        dp[ind1][ind2]=Math.max(helper(ind1-1,ind2,word1,word2,dp),helper(ind1,ind2-1,word1,word2,dp));
        return dp[ind1][ind2];
    }
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[][] dp=new int[n1+1][n2+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int x=helper(n1,n2,word1,word2,dp);
        int total1=n1-x;
        int total2=n2-x;
        return total1+total2;
    }
}