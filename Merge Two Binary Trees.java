/**
Solution 2:
*/
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        
        int val = (t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0);
        TreeNode mergedTree = new TreeNode(val);
        
        mergedTree.left = mergeTrees((t1 != null ? t1.left : null), (t2 != null ? t2.left : null));
        mergedTree.right = mergeTrees((t1 != null ? t1.right : null), (t2 != null ? t2.right : null));
        
        return mergedTree;
    }
}

/**
Solution 1:
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null) return (t1 != null) ? t1 : t2;
        
        preorder(t1, t2);
        return t1;
    }
    
    public void preorder(TreeNode t1, TreeNode t2) {
        
        t1.val += t2.val;
        if(t1.left != null && t2.left != null)
            preorder(t1.left, t2.left);
        else if(t1.left == null && t2.left != null)
            t1.left = t2.left;
        
        if(t1.right != null && t2.right != null)
            preorder(t1.right, t2.right);
        else if(t1.right == null && t2.right != null)
            t1.right = t2.right;
    }
}
