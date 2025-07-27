class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            List<Integer> row=triangle.get(i);
            for(int j=0;j<row.size();j++){
                dp[i][j]=row.get(j);
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                dp[i][j]=dp[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);

            }
        }
        return dp[0][0];
    }
}