class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;

        int output = 0;
        int n = x;
        while(n != 0){
            int temp = n % 10;
            output = output*10 + temp;
            n /= 10;
        }
        if(output == x) return true;
        else return false;
    }
}