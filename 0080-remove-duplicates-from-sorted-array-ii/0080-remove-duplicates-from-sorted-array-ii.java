

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == Integer.MAX_VALUE) continue;
            int x = nums[i];
            int y = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == Integer.MAX_VALUE) continue;
                if (x == nums[j]) {
                    y++;
                    if (y > 2) {
                        nums[j] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        Arrays.sort(nums);

        int c = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == Integer.MAX_VALUE) break;
            c++;
        }

        return c;
    }
}