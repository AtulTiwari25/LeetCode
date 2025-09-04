class Solution {
    public boolean isNumber(String s) {
        boolean digit = false;
        boolean expo = false;
        boolean deci = false;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                digit = true;
            } else if(ch == '.') {
                if(deci || expo) {
                    return false;
                }
                deci = true;
            } else if(ch == 'e' || ch == 'E') {
                if(expo || !digit) {
                    return false;
                }
                expo = true;
                digit = false;
            } else if(ch == '+' || ch == '-') {
                if(i != 0 && s.charAt(i-1) != 'e'&& s.charAt(i-1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return digit;
    }
}