class Solution {
    public long minimumDifference(int[] nums) {
        int totalLen = nums.length;
        int n = totalLen / 3;

        long[] leftMinSum = new long[totalLen];
        long[] rightMaxSum = new long[totalLen];

        // For left min-sum (pick smallest n from first 2n)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long leftSum = 0;

        for (int i = 0; i < n; i++) {
            maxHeap.add(nums[i]);
            leftSum += nums[i];
        }
        leftMinSum[n - 1] = leftSum;

        for (int i = n; i < 2 * n; i++) {
            maxHeap.add(nums[i]);
            leftSum += nums[i];
            leftSum -= maxHeap.poll(); // Keep only smallest n values
            leftMinSum[i] = leftSum;
        }

        // For right max-sum (pick largest n from last 2n)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;

        for (int i = totalLen - 1; i >= 2 * n; i--) {
            minHeap.add(nums[i]);
            rightSum += nums[i];
        }
        rightMaxSum[2 * n] = rightSum;

        for (int i = 2 * n - 1; i >= n; i--) {
            minHeap.add(nums[i]);
            rightSum += nums[i];
            rightSum -= minHeap.poll(); // Keep only largest n values
            rightMaxSum[i] = rightSum;
        }

        // Compare all possible divisions
        long result = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            result = Math.min(result, leftMinSum[i] - rightMaxSum[i + 1]);
        }

        return result;
    }
}