class Solution {
    private int helper(int ind1,int ind2,String s,String p,int[][] dp){
        if(ind1==0&&ind2==0){
            return 1;
        }
        if(ind2==0&&ind1!=0){
            return 0;
        }
        if(ind1==0){
            for(int i=0;i<ind2;i++){
                if(p.charAt(i)!='*'){
                    return 0;
                }
            }
            return 1;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1-1)==p.charAt(ind2-1)||p.charAt(ind2-1)=='?'){
            dp[ind1][ind2]=helper(ind1-1,ind2-1,s,p,dp);
            return dp[ind1][ind2];
        }
        if(p.charAt(ind2-1)=='*'){
            dp[ind1][ind2]=helper(ind1-1,ind2,s,p,dp)+helper(ind1,ind2-1,s,p,dp);
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1-1)!=p.charAt(ind2-1)){
            return 0;
        }
        return 1;
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int[][] dp=new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int x=helper(n,m,s,p,dp);
        if(x==0){
            return false;
        }
        return true;
    }
}