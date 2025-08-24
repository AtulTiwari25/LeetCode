class Solution {
    public int uniquePaths(int m, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 1;
        }
        for (int j = 0; j < m - 1; j++) {
            for (int i = 1; i < n; i++) {
                a[i] = a[i] + a[i - 1];
            }
        }
        return a[n - 1];
    }
}