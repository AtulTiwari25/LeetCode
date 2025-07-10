import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps_orig = new int[n+1];
        gaps_orig[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps_orig[i] = startTime[i] - endTime[i-1];
        }
        gaps_orig[n] = eventTime - endTime[n-1];

        int originalMaxGap = 0;
        for (int gap : gaps_orig) {
            if (gap > originalMaxGap) {
                originalMaxGap = gap;
            }
        }
        int maxGap = originalMaxGap;

        List<Integer> allGaps = new ArrayList<>();
        for (int gap : gaps_orig) {
            allGaps.add(gap);
        }
        for (int i = 0; i < n; i++) {
            int G_i;
            if (i == 0) {
                G_i = (n > 1) ? startTime[1] : eventTime;
            } else if (i == n-1) {
                G_i = eventTime - endTime[n-2];
            } else {
                G_i = startTime[i+1] - endTime[i-1];
            }
            allGaps.add(G_i);
        }

        List<Integer> sortedUnique = allGaps.stream().distinct().sorted().collect(Collectors.toList());
        Map<Integer, Integer> gapToIndex = new HashMap<>();
        int size = sortedUnique.size();
        for (int i = 0; i < size; i++) {
            gapToIndex.put(sortedUnique.get(i), i+1);
        }

        Fenw fenw = new Fenw(size);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int gap : gaps_orig) {
            int idx = gapToIndex.get(gap);
            fenw.update(idx, 1);
            treeMap.put(gap, treeMap.getOrDefault(gap, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int d_i = endTime[i] - startTime[i];
            int G_i;
            if (i == 0) {
                G_i = (n > 1) ? startTime[1] : eventTime;
            } else if (i == n-1) {
                G_i = eventTime - endTime[n-2];
            } else {
                G_i = startTime[i+1] - endTime[i-1];
            }

            int gap1 = (i == 0) ? gaps_orig[0] : gaps_orig[i];
            int gap2 = (i == n-1) ? gaps_orig[n] : gaps_orig[i+1];

            remove(fenw, treeMap, gapToIndex, gap1);
            remove(fenw, treeMap, gapToIndex, gap2);
            add(fenw, treeMap, gapToIndex, G_i);

            if (treeMap.isEmpty()) {
                maxGap = Math.max(maxGap, originalMaxGap);
            } else {
                Integer ceilKey = treeMap.ceilingKey(d_i);
                if (ceilKey == null) {
                    maxGap = Math.max(maxGap, originalMaxGap);
                } else {
                    int startIdx = gapToIndex.get(ceilKey);
                    int count_ge = fenw.rangeQuery(startIdx, size);

                    int M1 = treeMap.lastKey();
                    int M2;
                    if (treeMap.get(M1) > 1) {
                        M2 = M1;
                    } else {
                        Integer lower = treeMap.lowerKey(M1);
                        M2 = (lower != null) ? lower : 0;
                    }

                    int candidate_i;
                    if (count_ge == 0) {
                        candidate_i = originalMaxGap;
                    } else if (count_ge >= 2) {
                        candidate_i = M1;
                    } else {
                        candidate_i = Math.max(M2, M1 - d_i);
                    }
                    maxGap = Math.max(maxGap, candidate_i);
                }
            }

            remove(fenw, treeMap, gapToIndex, G_i);
            add(fenw, treeMap, gapToIndex, gap1);
            add(fenw, treeMap, gapToIndex, gap2);
        }

        return maxGap;
    }

    private void add(Fenw fenw, TreeMap<Integer, Integer> treeMap, Map<Integer, Integer> gapToIndex, int gap) {
        treeMap.put(gap, treeMap.getOrDefault(gap, 0) + 1);
        int idx = gapToIndex.get(gap);
        fenw.update(idx, 1);
    }

    private void remove(Fenw fenw, TreeMap<Integer, Integer> treeMap, Map<Integer, Integer> gapToIndex, int gap) {
        int count = treeMap.get(gap);
        if (count == 1) {
            treeMap.remove(gap);
        } else {
            treeMap.put(gap, count - 1);
        }
        int idx = gapToIndex.get(gap);
        fenw.update(idx, -1);
    }

    static class Fenw {
        int n;
        int[] tree;

        public Fenw(int size) {
            n = size;
            tree = new int[n+1];
        }

        public void update(int index, int delta) {
            while (index <= n) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }

        public int rangeQuery(int l, int r) {
            if (l > r) return 0;
            return query(r) - query(l-1);
        }
    }
}