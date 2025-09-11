class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> processed = new ArrayList<>();
        return helper(processed, nums);
    }

    static List<List<Integer>> helper(List<Integer> processed, int[] nums) {
        if (nums.length == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(processed)); // Make a copy to avoid mutation
            return ans;
        }

        // Exclude current element
        List<List<Integer>> left = helper(new ArrayList<>(processed), Arrays.copyOfRange(nums, 1, nums.length));

        // Include current element
        processed.add(nums[0]);
        List<List<Integer>> right = helper(new ArrayList<>(processed), Arrays.copyOfRange(nums, 1, nums.length));

        left.addAll(right); // Merge both sides
        return left;
    }
}