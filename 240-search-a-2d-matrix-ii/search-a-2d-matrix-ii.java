class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            int l=0;
            int r=m-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(matrix[i][mid]==target){
                    return true;
                }
                else if(matrix[i][mid]>target){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
        }return false;
    }
}