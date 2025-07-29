class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, s);
        return result;
    }
    
    private void backtrack(List<List<String>> result, List<String> path, int index, String s) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                backtrack(result, path, i + 1, s);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}