class Solution {
    public int myAtoi(String s) {
        s = s.trim(); // Remove leading and trailing whitespaces
        
        if (s.isEmpty()) return 0; // Return 0 if the string is empty
        
        int i = 0;
        boolean negative = false;
        
        // Check for sign
        if (s.charAt(0) == '-') {
            negative = true;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }
        
        int result = 0;
        int maxDiv10 = Integer.MAX_VALUE / 10;
        
        // Convert characters to integer
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Check for overflow
            if (result > maxDiv10 || (result == maxDiv10 && digit > 7)) {
                return (negative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return (negative) ? -result : result;
    }
}