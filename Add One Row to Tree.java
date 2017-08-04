public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        TreeNode dummyHead = new TreeNode(0);
        dummyHead.left = root;
        preorder(dummyHead, v, d, 0);
        return dummyHead.left;
    }
    
    public void preorder(TreeNode node, int v, int d, int level) {
        if(level >= d || node == null) return;
        if(level == d - 1) {
            TreeNode newNodeL = new TreeNode(v);
            TreeNode newNodeR = new TreeNode(v);
            newNodeL.left = node.left;
            newNodeR.right = node.right;
            node.left = newNodeL;
            node.right = newNodeR;
            return;
        }
        preorder(node.left, v, d, level + 1);
        preorder(node.right, v, d, level + 1);
    }
}
