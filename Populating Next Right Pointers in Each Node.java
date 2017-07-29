/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        connect(root.left);
        connect(root.right);
        root.left.next = root.right;
        root.right.next = null;
        
        if(root.left.right != null && root.right.left != null) {
            TreeLinkNode nLR = root.left.right;
            TreeLinkNode nRL = root.right.left;
            do {
                nLR.next = nRL;
                nLR = nLR.right;
                nRL = nRL.left;
            } while(nLR != null && nRL != null);
        }
    }
}
