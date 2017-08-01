/**
Solution 2:
 */
public class Solution {
    
    public int findBottomLeftValue(TreeNode root) {
        int[] res = {0, 0}; // {level, val}
        preorder(root, 1, res);
        return res[1];
    }
    
    public void preorder(TreeNode node, int level, int[] res) {
        if(level > res[0]) {
            res[0] = level;
            res[1] = node.val;
        }
        if(node.left != null) preorder(node.left, level + 1, res);
        if(node.right != null) preorder(node.right, level + 1, res);     
    }
}

/**
Solution 1:
*/
public class Solution {
    
    int maxDepth = -1;
    TreeNode leftMost;
    
    public int findBottomLeftValue(TreeNode root) {
        preorder(root, 0);
        return leftMost.val;
    }
    
    public void preorder(TreeNode node, int depth) {
        if(node == null) return;
        if(depth > maxDepth) {
            maxDepth = depth;
            leftMost = node;
        }
        preorder(node.left, depth + 1);
        preorder(node.right, depth + 1);     
    }
}
