class Solution {
    private void dfs(char[][] board,int row,int col,int[][] visited){
        visited[row][col]=1;
        // board[row][col]='O';
        int n=board.length;
        int m=board[0].length;
        int[] delRow={1,0,-1,0};
        int[] delCol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(ncol>=0 && ncol<m && nrow>=0 && nrow<n && visited[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(board,nrow,ncol,visited);
            }
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] visited=new int[n][m];
        for(int i=0;i<n;i++){
            char x=board[i][0];
            if(x=='O'){
                dfs(board,i,0,visited);
            }
        }
        for(int i=0;i<n;i++){
            char x=board[i][m-1];
            if(x=='O'){
                dfs(board,i,m-1,visited);
            }
        }
        for(int i=0;i<m;i++){
            char x=board[0][i];
            if(x=='O'){
                dfs(board,0,i,visited);
            }
        }
        for(int i=0;i<m;i++){
            char x=board[n-1][i];
            if(x=='O'){
                dfs(board,n-1,i,visited);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'&&visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
}