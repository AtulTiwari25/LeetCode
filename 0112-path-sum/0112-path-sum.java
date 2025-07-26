/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int target = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return recSum(root, 0);
    }
    public boolean recSum(TreeNode root, int currSum) {
        if (root == null) return false;
        // System.out.println("val:" + root.val + " sum:" + currSum);
        boolean res = false;
        if (root.left != null){
            res = recSum(root.left, currSum + root.val);
            if (res) return res;
        }
        if (root.right != null){
            res = recSum(root.right, currSum + root.val);
            if (res) return res;
        }
        if (currSum + root.val == target && root.left == null && root.right == null) return true;
        return res;
    }
}