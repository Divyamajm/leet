class Solution {
    private void row(int row,int[][] matrix){
        int m=matrix[0].length;
        for(int i=0;i<m;i++){
            if(matrix[row][i]!=0){
                matrix[row][i]=Integer.MIN_VALUE+88;
            }
        }
    }
    private void col(int col,int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++){
            if(matrix[i][col]!=0){
                matrix[i][col]=Integer.MIN_VALUE+88;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row(i,matrix);
                    col(j,matrix);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==Integer.MIN_VALUE+88){
                    matrix[i][j]=0;
                }
            }
        }
    }
}