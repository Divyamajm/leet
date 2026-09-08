class Solution {
    public boolean dfs(int row,int col,int ind,char[][] board,String word){
        if(ind==word.length()){
            return true;
        }
        if(row<0||col<0||row>=board.length||col>=board[0].length||board[row][col]!=word.charAt(ind)){
            return false;
        }
        char temp=board[row][col];
        board[row][col]='#';
        int[] delRow={-1,1,0,0};
        int[] delCol={0,0,-1,1};
        for(int i=0;i<4;i++){
            int r=row+delRow[i];
            int c=col+delCol[i];
            if(dfs(r,c,ind+1,board,word)){
                return true;
            }
        }
        board[row][col]=temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)&&dfs(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
}