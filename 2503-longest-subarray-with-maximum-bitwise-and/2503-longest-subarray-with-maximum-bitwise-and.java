class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        // Start by assuming the first element is the maximum
        int max = nums[0];

        // maxLength = length of longest streak of max so far
        // currStreak = length of current streak of max
        int maxLength = 0, currStreak = 0;

        for (int i = 0; i < n; i++) {

            // Found a new max, so reset everything
            if (max < nums[i]) {
                max = nums[i];       // update max
                maxLength = 0;       // reset longest length
                currStreak = 0;      // reset current streak
            }

            // If current number equals max, increase the streak
            if (max == nums[i]) {
                currStreak++;
            } else {
                // Not equal to max → reset current streak
                currStreak = 0;
            }

            // Update longest streak found so far
            maxLength = Math.max(maxLength, currStreak);
        }

        return maxLength;
    }
}