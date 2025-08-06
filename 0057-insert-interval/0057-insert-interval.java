class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;

        int nf = newInterval[0];
        int ns = newInterval[1];

        boolean inserted = false;

        for (int i = 0; i < n; i++) {
            int f = intervals[i][0];
            int s = intervals[i][1];
            if (s < nf) {
                list.add(new int[]{f, s});
            }
            else if (f > ns) {
                if (!inserted) {
                    list.add(new int[]{nf, ns});
                    inserted = true;
                }
                list.add(new int[]{f, s});
            }
            else {
                nf = Math.min(nf, f);
                ns = Math.max(ns, s);
            }
        }
        if (!inserted) {
            list.add(new int[]{nf, ns});
        }
        return list.toArray(new int[list.size()][]);
    }
}