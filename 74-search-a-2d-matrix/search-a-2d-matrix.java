class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int x=0;
        int y=n-1;
        while(x<=y){
            int mid=x+(y-x)/2;
            if(matrix[mid][m-1]>=target){
                y=mid-1;
            }
            else{
                x=mid+1;
            }
        }
        if (x >= n) {
            return false;
        }
        int l=0;
        int r=m-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(matrix[x][mid]==target){
                return true;
            }
            else if(matrix[x][mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return false;
    }
}
// while(l<=r){
//                 int mid=l+(r-l)/2;
//                 if(matrix[i][mid]==target){
//                     return true;
//                 }
//                 else if(matrix[i][mid]>target){
//                     r=mid-1;
//                 }
//                 else{
//                     l=mid+1;
//                 }
//             }