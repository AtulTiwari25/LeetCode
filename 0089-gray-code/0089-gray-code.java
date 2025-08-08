class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int limit = 1 << n; // 2^n
        for (int i = 0; i < limit; i++) {
            result.add(i ^ (i >> 1)); // Gray code formula
        }
        return result;
    }
}