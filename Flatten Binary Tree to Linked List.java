public class Solution {
    
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}


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
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
    
        flatten(left);
        flatten(right);
        
        root.left = null;
        root.right = left;
        
        TreeNode cur = root;
        while(cur.right != null)
            cur = cur.right;
        cur.right = right;
    }
}
