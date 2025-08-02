class Solution {
public:
    int singleNumber(vector<int>& arr) {
        
        int n = arr.size();
        if(n==1) return arr[0];
        
        int bitwiseXor = 0;
        for(auto num : arr) {
            bitwiseXor ^= num;
        }

        return bitwiseXor;
    }
};