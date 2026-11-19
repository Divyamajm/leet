class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix[0].length;
        int m=matrix.length;
        int[] row=new int[m];
        Arrays.fill(row,0);
        int[] col=new int[n];
        Arrays.fill(col,0);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i]==1|| col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}