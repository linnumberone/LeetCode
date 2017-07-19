/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        
        while(head != null) {
            ListNode insertNode = head;
            ListNode cur = newHead;
            while(cur.next != null && insertNode.val > cur.next.val) {
                cur = cur.next; 
            }
            head = head.next;
            insertNode.next = cur.next;
            cur.next = insertNode;
        }
        return newHead.next;
    }
}
