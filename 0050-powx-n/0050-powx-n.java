class Solution {
 public double myPow(double x, int n) {
        if(x==0)return 0;
        if(n>=0)return helper(x, n);
        else return (helper(1/x,Math.abs((long)n)));
    }
    public double helper(double val, long n){
        if(n==0)return 1;
        if(n==1)return val;
        if(n%2!=0)return helper(val, n-1)*val;
        else return helper(val*val, n/2);
    }
}