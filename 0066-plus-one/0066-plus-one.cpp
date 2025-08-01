class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        vector<int> result;
        int n = digits.size();
        if(digits[n-1]<9){
            digits[n-1] +=1;
            return digits;
        }
        else{
           int carry = 1;
           for(int i= n-1;i>=0;i--){
             int sum = digits[i]+carry;
             if(sum==10){
                result.insert(result.begin(),0);
                carry = 1;
             }
             else{
                result.insert(result.begin(),sum);
                carry = 0;
             }
           }
           if(carry == 1){
            result.insert(result.begin(),1);
           }
        }
        return result;
    }
};
