class Solution {

    public int solve(int x, int y, int [][] grid, int[][] dp){
        if(x<0 || y<0 || x>=grid.length || y>= grid[0].length || grid[x][y] != 0 ){
            dp[x][y] = 0;
            return 0;
        }
        if(x == grid.length-1 && y == grid[0].length-1){
            return 1;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }

        dp[x][y] = solve(x,y+1,grid,dp) + solve(x+1,y,grid,dp);
        return dp[x][y];

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        for(int i = 0;i<obstacleGrid.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0,0,obstacleGrid,dp);
    }
}