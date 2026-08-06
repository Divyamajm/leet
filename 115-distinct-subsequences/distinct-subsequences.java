class Solution {
    // private int helper(int ind1,int ind2,String s,String t,int[][]dp){
    //     if(ind2==0){
    //         return 1;
    //     }
    //     if(ind1==0){
    //         return 0;
    //     }
    //     if(dp[ind1][ind2]!=-1){
    //         return dp[ind1][ind2];
    //     }
    //     if(s.charAt(ind1-1)==t.charAt(ind2-1)){
    //         dp[ind1][ind2]=helper(ind1-1,ind2-1,s,t,dp)+helper(ind1-1,ind2,s,t,dp);
    //         return dp[ind1][ind2];
    //     }
    //     dp[ind1][ind2]=helper(ind1-1,ind2,s,t,dp);
    //     return dp[ind1][ind2];
    // }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][]dp=new int[n+1][m+1];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=m;i++){
            dp[0][i]=0;
        }
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s.charAt(ind1-1)==t.charAt(ind2-1)){
                    dp[ind1][ind2]=dp[ind1-1][ind2-1]+dp[ind1-1][ind2];
                    // return dp[ind1][ind2];
                }
                else{
                    dp[ind1][ind2]=dp[ind1-1][ind2];
                }
            }
        }
        return dp[n][m];
    }
}