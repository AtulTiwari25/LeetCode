class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) return s;
        
        StringBuilder res = new StringBuilder();
        int cycleLen = 2 * numRows - 2;
        
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < n; j += cycleLen) {
                res.append(s.charAt(j));
                int second = j + cycleLen - 2 * i;
                if (i != 0 && i != numRows - 1 && second < n)
                    res.append(s.charAt(second));
            }
        }
        
        return res.toString();
    }
}