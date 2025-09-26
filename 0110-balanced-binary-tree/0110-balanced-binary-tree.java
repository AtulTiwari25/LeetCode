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
    public boolean isBalanced(TreeNode root) {
        return balance(root).isbal;
    }
    class BalancedPair{
        boolean isbal=true;
        int ht=-1;
    }
    public BalancedPair balance(TreeNode root){
        if(root==null){
            return new BalancedPair();
        }
        BalancedPair lbp=balance(root.left);
        BalancedPair rbp=balance(root.right);
        BalancedPair sbp=new BalancedPair();
        sbp.ht=Math.max(lbp.ht,rbp.ht)+1;
        boolean sb=Math.abs(lbp.ht-rbp.ht)<=1;
        sbp.isbal=sb && lbp.isbal && rbp.isbal;
        return sbp;
    }
}