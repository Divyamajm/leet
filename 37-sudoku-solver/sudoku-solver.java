class Solution {
    public boolean isSafe(char[][] board,int row,int col,char k){
        for(int i=0;i<9;i++){
            if(board[i][col]==k){
                return false;
            }
            if(board[row][i]==k){
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==k){
                return false;
            }
        }return true;
    }
    public boolean helper(char[][] board){
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isSafe(board,i,j,k)){
                            board[i][j]=k;
                            if(helper(board)==true){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }
                    }return false;
                }
            }
        }return true;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }
}