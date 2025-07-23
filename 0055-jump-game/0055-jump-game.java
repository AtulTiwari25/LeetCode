class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }

        int obj = nums.length-1;

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i >=obj){
                obj = i;
            }
        }
        if(obj == 0){
            return true;
        }
        else return false;
    }
}