class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer>ans = new ArrayList<>();
        List<List<Integer>>res = new ArrayList<>();
        print(n, k, 1, ans, res); 
        return res;
    }
    private void print(int n,int k, int idx, List<Integer> ans, List<List<Integer>> res) {
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=idx ; i<=n ;i++){
            ans.add(i);
            print(n,k,i+1,ans,res);
            ans.remove(ans.size() - 1);
        }
    }

}