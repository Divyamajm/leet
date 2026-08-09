class Solution {
    private void dfs(int row,int col,char[][] grid,int[][] visited){
        int n=grid.length;
        int m=grid[0].length;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,-1,0,1};
        for(int i=0;i<4;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            if(nRow>=0&&nRow<n&&nCol>=0&&nCol<m){
                if(grid[nRow][nCol]=='1' && visited[nRow][nCol]!=1){
                    visited[nRow][nCol]=1;
                    dfs(nRow,nCol,grid,visited);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&&visited[i][j]!=1){
                    count++;
                    dfs(i,j,grid,visited);
                }
            }
        }return count;
    }
}