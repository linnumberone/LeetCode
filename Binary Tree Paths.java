/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root != null)
            createPath(root, res, "");

        return res;
    }
    
    public void createPath(TreeNode root, List<String> res, String path) {
        if(root.left == null && root.right == null)
            res.add(path + root.val);
        if(root.left != null)
            createPath(root.left, res, path + root.val + "->");
        if(root.right != null)
            createPath(root.right, res, path + root.val + "->");
    }
}
