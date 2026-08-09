class Solution {
    private void dfs(int row,int col,int[][]visited,int[][] image,int x,int color){
        int n=image.length;
        int m=image[0].length;
        visited[row][col]=1;
        image[row][col]=color;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int r=row+delRow[i];
            int c=col+delCol[i];
            if(r>=0&&r<n&&c>=0&&c<m&&visited[r][c]==0&&image[r][c]==x){
                dfs(r,c,visited,image,x,color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int[][] visited=new int[n][m];
        int x=image[sr][sc];
        dfs(sr,sc,visited,image,x,color);
        return image;
    }
}