class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int topRow = 0 , bottomRow=r-1, leftCol=0, rightCol=c-1;

        Integer[]ans = new Integer[r*c];
        
        int totalElements = 0;
        

        while(totalElements<r*c)
        {
            //topRow = leftCol to Rightcol

            for(int j=leftCol; j<=rightCol && totalElements<r*c; j++)
            {
             ans[totalElements] = matrix[topRow][j];
                totalElements++;
            }
            topRow++;

            //rightCol = topRow to bottomRow

            for(int i=topRow; i<=bottomRow && totalElements<r*c; i++)
            {
              ans[totalElements] =  matrix[i][rightCol];
                totalElements++;
            }
            rightCol--;

            //bottomRow = rightCol to leftcol

            for(int j=rightCol; j>=leftCol && totalElements<r*c; j--)
            {
               ans[totalElements] = matrix[bottomRow][j];
                totalElements++;
            }
            bottomRow--;

            //leftCol = bottomRow to TopRow

            for(int i=bottomRow; i>=topRow && totalElements<r*c; i--)
            {
               ans[totalElements] = matrix[i][leftCol];
                totalElements++;
            }
            leftCol++;
        }
        
        return Arrays.asList(ans);
    }
}