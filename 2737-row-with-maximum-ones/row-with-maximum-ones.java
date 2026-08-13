class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[] result=new int[2];
        int maxCount=0;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            if(count>maxCount){
                result[0]=i;
                result[1]=count;
            }
            maxCount=Math.max(maxCount,count);
        }return result;
    }
}