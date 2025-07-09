class Solution {
    public int maxArea(int[] height) {
        int prod = 0;
        int i=0, j = height.length - 1;
        while(i < j){
            int min = Math.min(height[i], height[j]);
            prod = Math.max(prod, min*(j-i));
             if(height[i] > height[j])
                j--;
            else    
                i++;
        }

        return prod;
        
    }
}