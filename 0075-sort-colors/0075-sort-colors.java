class Solution {
    public void sortColors(int[] nums) {
        int i = 0; 
        int j = 0;
        int n1 = 0;
        int a = 0;
        
        while (i < nums.length && n1 < 3) {
            a = 0;
            
            if (j >= nums.length) {
                n1++;
                j = i;
                continue;
            }

            if (nums[j] == n1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
                a = 1;
            }

            if (a != 1) {
                j++;
            }
        }
    }
}