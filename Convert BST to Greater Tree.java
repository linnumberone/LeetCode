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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root != null)
            preorder(root, 1, res);
        return res;
    }
    
    public void preorder(TreeNode node, int level, List<Integer> res) {
        if(level > res.size()) 
            res.add(node.val);
        else if(node.val > res.get(level - 1))
            res.set(level - 1, node.val);
        if(node.left != null) preorder(node.left, level + 1, res);
        if(node.right != null) preorder(node.right, level + 1, res);
    }
}
