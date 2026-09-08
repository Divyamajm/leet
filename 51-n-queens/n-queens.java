class Solution {
    public boolean isSafe(int row,int col,char[][] board){
        int r=row;
        int c=col;
        while(r>=0&&c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c--;
        }
        r=row;
        c=col;
        while(c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            c--;
        }
        c=col;
        while(r<board.length&&c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r++;
            c--;
        }
        return true;
    }
    public List<String> construct(char[][] board){
        List<String>result=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            result.add(new String(board[i]));
        }
        return result;
    }
    public void helper(int col,char[][] board,List<List<String>>result,int n){
        if(col==n){
            result.add(construct(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board)){
                board[row][col]='Q';
                helper(col+1,board,result,n);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        helper(0,board,result,n);
        return result;
    }
}