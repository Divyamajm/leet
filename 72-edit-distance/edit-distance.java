class Solution {
    // private int helper(int ind1,int ind2,String word1,String word2,int[][]dp){
    //     if(ind1==0){
    //         return ind2;
    //     }
    //     if(ind2==0){
    //         return ind1;
    //     }
    //     if(dp[ind1][ind2]!=-1){
    //         return dp[ind1][ind2];
    //     }
    //     if(word1.charAt(ind1-1)==word2.charAt(ind2-1)){
    //         // return 
    //         dp[ind1][ind2]=helper(ind1-1,ind2-1,word1,word2,dp);
    //         return dp[ind1][ind2];
    //     }
    //     else{
    //         dp[ind1][ind2]=1+Math.min(helper(ind1-1,ind2,word1,word2,dp),Math.min(helper(ind1,ind2-1,word1,word2,dp),helper(ind1-1,ind2-1,word1,word2,dp)));
    //         return dp[ind1][ind2];
    //     }
    // }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];
        int[] prev=new int[m+1];
        int[] temp=new int[m+1];
        // for(int[]row: dp){
        //     Arrays.fill(row,-1);
        // }
        for(int i=0;i<=m;i++){
            prev[i]=i;
        }
        // for(int i=1;i<=m;i++){
        //     prev[i]=i;
        // }
        for(int ind1=1;ind1<=n;ind1++){
            temp[0]=ind1;
            for(int ind2=1;ind2<=m;ind2++){
                if(word1.charAt(ind1-1)==word2.charAt(ind2-1)){
                    // return 
                    temp[ind2]=prev[ind2-1];
                    // return dp[ind1][ind2];
                }
                else{
                    temp[ind2]=1+Math.min(prev[ind2],Math.min(temp[ind2-1],prev[ind2-1]));
                    // return dp[ind1][ind2];
                }
            }prev=temp.clone();
        }
        return prev[m];
    }
}