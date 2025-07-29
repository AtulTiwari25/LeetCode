class Solution {
    //get the max index from bits 
    int getMax(int[] bits){
        int max = 0;
        for(int i =0;i<32;i++)
            max = Math.max(max,bits[i]);
        return max;
    }
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        //store the last nearest postion such that ith bit is set
        int[] bits = new int[32];
        for(int i = n-1;i>=0;i--){
            int num = nums[i];
            int k = 0;
            //update the bits array according to the current element
            while(num>0){
                if(num%2 == 1)
                    bits[k] = i;
                k++;
                num /=2;
            }
            int max = getMax(bits);
            //check max == 0 means that their is no bit set
            //so that means that max possible or is 0 
            //that can be generated using only one element (current) so 1
            if(max == 0) nums[i]= 1;
            //else max possible position from bits -i +1 gives the length
            else nums[i] = max-i+1;
        }
        return nums;
    }
}