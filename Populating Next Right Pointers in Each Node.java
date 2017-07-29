/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

/**
Solution 2: 參考別人的聰明解法，邊 traverse 邊串聯兩顆分開的樹
*/
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}

/**
Solution 1: 第一次自己想的解法，缺點是要串連兩個分開的 subtree 時，必須要重新 traverse
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
