class Solution {
    public int countMaxOrSubsets(int[] nums) {
        //accoriding to the hint ,the max or of the array is ,the or of all the elemnts in the array
        //this is coz when ever we or smtg the reult is going to stay the same or increase but never decrese 
        //as 0|0 is 0 but 0|1 is one so we always increase
        int maxor=0;
        // here we are counting the maximum or of the array
        for(int i:nums){
            maxor|=i;
        }
        int n=nums.length;
        //we send it into a recurcise funtion to count all the subsets whose or is maxor
        return solve(nums,n-1,maxor,0);
    }
    int solve(int[] nums,int ind,int max,int cur){
        //if the ind is less than 0 we directly check if the current or is equal to max and 
        if(ind<0){
            //increment the ruslt by one if it is equal
            return max==cur?1:0;
        }
        //as per clasic subset logic we can at a particular index pick or notpick the elemt
        //if we dont pick we then the index decreases but cur stays the same 
        int notpick=solve(nums,ind-1,max,cur);
        //if we pick the index changes so as the cur value
        int pick=solve(nums,ind-1,max,cur|nums[ind]);
        // we add both the no of subsets we can get which equal to the maxor
        return pick+notpick;
    }
}