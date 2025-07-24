class Solution {
    private int calc(int a, int b, int c) {
        return Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }

    private void dfs(int x, int parent, int[] cnt, int[] nums, int[] sum, int[] in, int[] out, List<Integer>[] adj) {
        in[x] = cnt[0]++;
        sum[x] = nums[x];
        for (int y : adj[x]) {
            if (y == parent) continue;
            dfs(y, x, cnt, nums, sum, in, out, adj);
            sum[x] ^= sum[y];
        }
        out[x] = cnt[0];
    }
    
    public int minimumScore(int[] nums, int[][] edges) {
        final int n = nums.length;
        int[] cnt = new int[1]; // mutable counter
        int[] sum = new int[n], in = new int[n], out = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(0, -1, cnt, nums, sum, in, out, adj);
        int res = Integer.MAX_VALUE;
        for (int u = 1; u < n; ++u) {
            for (int v = u + 1; v < n; ++v) {
                if (in[v] > in[u] && in[v] < out[u]) res = Math.min(res, calc(sum[0] ^ sum[u], sum[u] ^ sum[v], sum[v]));
                else if (in[u] > in[v] && in[u] < out[v]) res = Math.min(res, calc(sum[0] ^ sum[v], sum[v] ^ sum[u], sum[u]));
                else res = Math.min(res, calc(sum[0] ^ sum[u] ^ sum[v], sum[u], sum[v]));
            }
        }

        return res;
    }
}