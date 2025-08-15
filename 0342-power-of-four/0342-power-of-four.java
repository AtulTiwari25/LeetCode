import java.util.*;
public class Solution {
    public boolean isPowerOfFour(int n) {
        int res=0;
        int rem=0;
        while(n>0){
            rem=n%4;
            res+=rem;
            n/=4;
        }
        return res==1;
    }
    public static void main(String[] args)
    {
        Solution sol=new Solution();
        System.out.println(sol.isPowerOfFour(4));
    }
}