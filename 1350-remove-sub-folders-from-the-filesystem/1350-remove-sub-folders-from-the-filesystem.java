class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String pre = "";
        for(String cur: folder) {
            if(pre == "" || !cur.startsWith(pre + "/")) {
                result.add(cur);
                pre = cur;
            }
        }
        return result;
    }
}