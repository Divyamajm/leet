class Solution {
    private int helper(int ind1,int ind2,String s,String s1,int[][] dp){
        if(ind1==0||ind2==0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1-1)==s1.charAt(ind2-1)){
            dp[ind1][ind2]=1+helper(ind1-1,ind2-1,s,s1,dp);
            return dp[ind1][ind2];
        }
        dp[ind1][ind2]=Math.max(helper(ind1-1,ind2,s,s1,dp),helper(ind1,ind2-1,s,s1,dp));
        return dp[ind1][ind2];
    }
    public int minInsertions(String s) {
        int n=s.length();
        String s1=new StringBuilder(s).reverse().toString();
        int[][]dp=new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int x=helper(n,n,s,s1,dp);
        return n-x;
    }
}