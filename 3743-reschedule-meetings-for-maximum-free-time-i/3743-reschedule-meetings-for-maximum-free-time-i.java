import java.util.*;

public class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> gaps = new ArrayList<>();
        
        // Initial gap before the first meeting
        gaps.add(startTime[0]);
        
        // Gaps between meetings
        for (int i = 1; i < n; i++) {
            gaps.add(startTime[i] - endTime[i - 1]);
        }
        
        // Gap after the last meeting
        gaps.add(eventTime - endTime[n - 1]);
        
        // Now, the problem reduces to finding the maximum possible sum of (k+1) consecutive gaps
        // Because merging m meetings (m <=k) allows combining m+1 gaps (before, between, after)
        int maxGap = 0;
        int currentSum = 0;
        int windowSize = k + 1;
        
        // We need to find the maximum sum of a window of size (k + 1) in the gaps array
        for (int i = 0; i < gaps.size(); i++) {
            currentSum += gaps.get(i);
            if (i >= windowSize) {
                currentSum -= gaps.get(i - windowSize);
            }
            if (i >= windowSize - 1) {
                maxGap = Math.max(maxGap, currentSum);
            }
        }
        
        // Also consider cases where windowSize exceeds the gaps size (but since k <=n, windowSize is k+1 <=n+1, gaps.size is n+1)
        // So the loop above covers all possibilities
        return maxGap;
    }
}