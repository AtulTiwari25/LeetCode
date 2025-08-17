class Solution {
    public int lengthOfLastWord(String s) {
        int len, i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ')
            i--;
        len = i;
        while (i >= 0 && s.charAt(i) != ' ')
            i--;
        return len - i;
    }
}