/*
Solution 2: 不需要大幅拆解 list
*/
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        
        ListNode dummy = new ListNode(0); // use dummy head to deal with the first node
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++)
            pre = pre.next;
        
        ListNode start = pre.next;
        ListNode then = start.next;
        
        for(int i = m; i < n; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}


/*
Solution 1: 自己解決的方式
*/
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        
        ListNode dummyHead = new ListNode(0); // use dummy head to deal with the first node
        ListNode preReverse = dummyHead;
        preReverse.next = head;
        for(int i = 1; i < m; i++) {
            preReverse = preReverse.next;
        }
        
        ListNode pre = null;
        ListNode cur = preReverse.next;
        
        for(int i = m; i <= n && cur != null; i++) {
            ListNode tmpNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmpNext;
        }
        ListNode firstReverse = preReverse.next;
        firstReverse.next = cur;
        preReverse.next = pre;
        
        return dummyHead.next;
    }
}
