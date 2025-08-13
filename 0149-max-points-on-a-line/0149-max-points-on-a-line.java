class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n; // Min. 2 point ho skte h

        int max = 2;

        for(int i = 0; i<points.length; i++){
            for(int j = i+1; j<points.length; j++){
                int total = 2; //Avi tk 2 point confirm h 
                for(int k = 0; k<n; k++){
                    if(k != i && k != j){
                        /* Slope dhundo class 12 formula
                        kosis kro equivalent ko multiply kr ke kre wrna decimal m position milega 
                        k jo h wo koi bhi point h jo satisfy kr raha h slope value to count kro usko */
                        if((points[j][1] - points[i][1])*(points[i][0] - points[k][0]) == (points[i][1] - points[k][1])*(points[j][0] - points[i][0])) {
                            total++;
                        }
                    }
                    max = Math.max(max,total);
                }
            }
        }
        return max;
    }
}