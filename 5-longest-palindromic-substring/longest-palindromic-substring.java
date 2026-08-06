class Solution {
    // private int helper(int ind1,int ind2,String s1,String s2,int[][]dp){
    //     if(ind1==0||ind2==0){
    //         return 0;
    //     }
    //     if(dp[ind1][ind2]!=-1){
    //         return dp[ind1][ind2];
    //     }
    //     if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
    //         dp[ind1][ind2]=1+helper(ind1-1,ind2-1,s1,s2,dp);
    //         return dp[ind1][ind2];
    //     }
    //     else{
    //         dp[ind1][ind2]=0;
    //         return dp[ind1][ind2];
    //     }
    // }
    public String longestPalindrome(String s) {
        int n=s.length();
        String s1=new StringBuilder(s).reverse().toString();
        int[][] dp=new int[n+1][n+1];
        int maxLength = 0;
        int endIndex = 0;
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        // int x=helper(n-1,n-1,s,s1,dp);
        for(int i=0;i<=n;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=n;ind2++){
                if(s1.charAt(ind1-1)==s.charAt(ind2-1)){
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                    // return dp[ind1][ind2];
                    if (dp[ind1][ind2] > maxLength) {
                        
                        // Mathematical check to verify it's a true palindrome, not a reverse-string anomaly
                        if (ind1 - dp[ind1][ind2] == n - ind2) {
                            maxLength = dp[ind1][ind2];
                            endIndex = ind2; 
                        }
                    }
                }
                else{
                    dp[ind1][ind2]=0;
                    // return dp[ind1][ind2];
                }
            }
        }
        // int n1=n;
        // int n2=n;
        // StringBuilder sb=new StringBuilder();
        // while(n1>0&&n2>0){
        //     if(s1.charAt(n1-1)==s.charAt(n2-1)){
        //         sb.append(s.charAt(n1-1));
        //         n1--;
        //         n2--;
        //     }
        //     else if(dp[n1-1][n2]>=dp[n1][n2-1]){
        //         n1--;
        //     }
        //     else{
        //         n2--;
        //     }
        // }
        // String result=sb.reverse().toString();
        return s.substring(endIndex - maxLength, endIndex);
    }
}