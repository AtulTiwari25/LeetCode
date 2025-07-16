public class Solution {
    public int maximumLength(int[] nums) {
        int maxEvenSum = 0; // Length of longest subsequence with all even sums
        int maxOddSum = 0;  // Length of longest subsequence with all odd sums
        int lastEven = 0;   // Length ending with even number for even sums
        int lastOdd = 0;    // Length ending with odd number for even sums
        int lastEvenOddSum = 0; // Length ending with even number for odd sums
        int lastOddOddSum = 0;  // Length ending with odd number for odd sums
        
        for (int num : nums) {
            if (num % 2 == 0) {
                // For even sums: can follow another even
                int newLastEven = lastEven + 1;
                // For odd sums: can follow an odd
                int newLastEvenOddSum = lastOddOddSum + 1;
                
                // Update max lengths
                maxEvenSum = Math.max(maxEvenSum, newLastEven);
                maxOddSum = Math.max(maxOddSum, newLastEvenOddSum);
                
                // Update trackers
                lastEven = newLastEven;
                lastEvenOddSum = newLastEvenOddSum;
            } else {
                // For even sums: can follow another odd
                int newLastOdd = lastOdd + 1;
                // For odd sums: can follow an even
                int newLastOddOddSum = lastEvenOddSum + 1;
                
                // Update max lengths
                maxEvenSum = Math.max(maxEvenSum, newLastOdd);
                maxOddSum = Math.max(maxOddSum, newLastOddOddSum);
                
                // Update trackers
                lastOdd = newLastOdd;
                lastOddOddSum = newLastOddOddSum;
            }
        }
        
        return Math.max(maxEvenSum, maxOddSum);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test cases
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(sol.maximumLength(nums1)); // Expected: 4
        
        int[] nums2 = {1, 2, 1, 1, 2, 1, 2};
        System.out.println(sol.maximumLength(nums2)); // Expected: 6
        
        int[] nums3 = {1, 3};
        System.out.println(sol.maximumLength(nums3)); // Expected: 2
    }
}
