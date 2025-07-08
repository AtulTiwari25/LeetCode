import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 1; i <= n; i++) {
            int start = events[i - 1][0];
            int value = events[i - 1][2];
            
            // Find the last event that ends before the current event starts
            int l = 0, r = i - 1;
            int lastNonOverlapping = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (events[mid][1] < start) {
                    lastNonOverlapping = mid + 1; // because events are 0-based in the original array
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[lastNonOverlapping][j - 1] + value);
            }
        }
        
        return dp[n][k];
    }
}