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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        backtrack(root,targetSum,new ArrayList<>(),res);
        return res;
    }
    private void backtrack(TreeNode root,int target,List<Integer>path,List<List<Integer>> res)
    {
        path.add(root.val);
        target-=root.val;
        if(root.left==null && root.right==null)
        {
            if(target==0)
            {
                res.add(new ArrayList<>(path));
            }
        }
        else
        {
            if(root.left!=null)
                backtrack(root.left,target,path,res);
            if(root.right!=null)
                backtrack(root.right,target,path,res);
        }
        path.remove(path.size()-1);

    }
}