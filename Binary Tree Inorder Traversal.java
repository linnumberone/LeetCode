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
    // Solution 1: iteration
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop(); // backtrace to higher level
            res.add(node.val); // add the value to the list
            node = node.right; // switch to look at right node
        }
        return res;
    }
    
    // Solution 2: recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversalHelper(root, res);
        return res;
    }
    
    private void traversalHelper(TreeNode node, List<Integer> res) {
        if(node == null) return;
        
        traversalHelper(node.left, res);
        res.add(node.val);
        traversalHelper(node.right, res);
    }
}
