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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        preorderTravel(root, preorderList);

        return preorderList;
    }

    private void preorderTravel(TreeNode root, List<Integer> preorderList) {
        if (root != null) {
            preorderList.add(root.val);
            if (root.left != null)
                preorderTravel(root.left, preorderList);
            if (root.right != null)
                preorderTravel(root.right, preorderList);
        }
    }
}