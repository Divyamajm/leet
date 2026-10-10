class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int l=0;
        int r=(n*m)-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int r1=mid/m;
            int c1=mid%m;
            if(target==matrix[r1][c1]){
                return true;
            }
            else if(target>matrix[r1][c1]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return false;
    }
}