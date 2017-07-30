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

        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode cur = dummyHead;
        while(root != null) {
            if(root.left != null) {
                cur.next = root.left;
                cur = cur.next;
            }
            if(root.right != null) {
                cur.next = root.right;
                cur = cur.next;
            }
            root = root.next;

            // prepare to move in next level
            if(root == null) {
                cur = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }
}
