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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getRootEachLevel(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    public TreeNode getRootEachLevel(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length - 1 || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        // find position of root in inorder array
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        
        root.left = getRootEachLevel(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = getRootEachLevel(preStart + (inIndex - inStart) + 1, inIndex + 1, inEnd, preorder, inorder);
        
        return root;
    }
}
