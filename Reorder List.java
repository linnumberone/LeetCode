/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode pre = null;
        ListNode cur = slow.next;
        slow.next = null;
        while(cur != null) {
            ListNode nextTmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTmp;
        }

        ListNode p1 = head;
        ListNode p2 = pre;
        while(p2 != null) {
            ListNode nextTmp1 = p1.next;
            ListNode nextTmp2 = p2.next;
            p1.next = p2;
            p2.next = nextTmp1;
            p1 = nextTmp1;
            p2 = nextTmp2;
        }
    }
}
