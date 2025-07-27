class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int lastNonEqal = nums[0];
        int n = nums.length;

        for(int i=1;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            if((nums[i]>lastNonEqal && nums[i]>nums[i+1])||(nums[i]<lastNonEqal && nums[i]<nums[i+1])){
                count++;
            }
            // Update only when current element is not equal to last
            lastNonEqal = nums[i];
        }
        return count;
    }
}