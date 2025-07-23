class Solution {
    private int getMax(String s, char a, char b, int x, int y){
        int c1 = 0, c2 = 0, ans = 0;
        s += 'c';
        for (char c: s.toCharArray()){
            if (c == a){
                c1++;
            } else if (c == b){
                if (c1 == 0){
                    c2++;
                } else {
                    ans += x;
                    c1--;
                }
            } else {
                ans += y * Math.min(c1, c2);
                c1 = c2 = 0;
            }
        }
        return ans;
    }
    public int maximumGain(String s, int x, int y) {
        if (x > y){
            return getMax(s, 'a', 'b', x, y);
        } else {
            return getMax(s, 'b', 'a', y, x);
        }
    }
}