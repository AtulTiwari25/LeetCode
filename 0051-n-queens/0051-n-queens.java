class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        backtrack(ans,board,n,0);
        return ans;
    }
    private void backtrack(List<List<String>> ans,char[][] board,int tq,int row){
        if(tq==0){
            List<String> ll=new ArrayList<>();
            for(char[] i:board){
                ll.add(new String(i));
            }
            ans.add(ll);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isItSafe(board,row,col)){
                board[row][col]='Q';
                backtrack(ans,board,tq-1,row+1);
                board[row][col]='.';
            }
        }
    }
    private boolean isItSafe(char[][] board,int row,int col){
        int r=row;
        while(r>=0){
            if(board[r][col]=='Q'){
                return false;
            }
            r--;
        }
        r=row;
        int c=col;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c--;
        }
        r=row;
        c=col;
        int n=board.length;
        while(r>=0 && c<n){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}