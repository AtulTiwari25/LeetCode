class Solution {
  
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
         int index =0;
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                    if(dfs(i,j,vis,board,0,word)){
                        return true;
                    }
            }
         }
         return false;
    }

    public static boolean dfs(int r,int c,boolean[][] vis,char[][] board,int index,String word){


        if(r<0 || r>=board.length || c<0 || c>=board[0].length || vis[r][c]==true || board[r][c]!=word.charAt(index)){
            return false;
        }
        
        if(index==word.length()-1){
            return true;
        }

        vis[r][c] = true;

        int[] dRow = {1,-1,0,0};
        int[] dCol = {0,0,1,-1};

        for(int i=0;i<4;i++){
            if(dfs(r+dRow[i],c+dCol[i],vis,board,index+1,word)){
                return true;
            }
        }
        vis[r][c]=false;
        return false;
    }
}