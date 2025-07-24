class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;

        // Sorted using Comparator
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0]; // Sorts based on the starting number of the pair.
            }
        });

        int[] oldInterval = intervals[0];
        List<int[]> result = new ArrayList<>();
        result.add(oldInterval);

        // Traverse all the arrays and merge intervals.
        for (int[] interval : intervals) {
            if (interval[0] <= oldInterval[1]) {
                // Means the last element of the old pair is greater than first element of new pair.
                // This can be merged
                oldInterval[1] = Math.max(oldInterval[1], interval[1]);
            } else {
                // Cannot be merged (Range difference), reassign oldInterval
                oldInterval = interval;
                result.add(oldInterval);
            }
        }

        // Convert to Result
        int[][] finalResult = result.toArray(new int[result.size()][]);
        return finalResult;
    }
}