class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][j]=Integer.MIN_VALUE+28;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==Integer.MIN_VALUE+28){
                    for(int k=0;k<m;k++){
                        if(matrix[i][k]!=Integer.MIN_VALUE+28){
                            matrix[i][k]=0;
                        }
                    }
                    // Arrays.fill(matrix[i],0);
                    for(int k=0;k<n;k++){
                        if(matrix[k][j]!=Integer.MIN_VALUE+28){
                            matrix[k][j]=0;
                        }
                    }
                    matrix[i][j]=Integer.MIN_VALUE+28;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==Integer.MIN_VALUE+28){
                    matrix[i][j]=0;
                }
            }
        }
    }
}