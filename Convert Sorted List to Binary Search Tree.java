/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head, null);
    }
    
    public TreeNode toBST(ListNode head, ListNode tail) {
        if(head == tail) return null;
        
        ListNode slow = head, fast = head;
        while(fast.next != tail && fast.next.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode tree = new TreeNode(slow.val);
        tree.left = toBST(head, slow);
        tree.right = toBST(slow.next, tail);
        
        return tree;
    }
}
