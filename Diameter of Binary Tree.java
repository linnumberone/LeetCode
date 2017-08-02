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
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        getLength(root);
        return max;
    }
    public int getLength(TreeNode node) {
        if(node == null) return 0;
        int left = getLength(node.left);
        int right = getLength(node.right);
        
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}
