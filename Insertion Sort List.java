/*
Solution 2: Although this solution is not insertion sort, it is a good way to solve the sorting problem. The performance is extremely good.
*/
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        List<Integer> values = new ArrayList<Integer>();
        while(head != null) {
            values.add(head.val);
            head = head.next;
        }
        Collections.sort(values);
        
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        for(int i : values) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return newHead.next;
    }
}


/*
Solution 1: Trivial solution
This solution is good and is reasonable to solve the problem. However, the performance of insertion sort is terrible.
*/
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(0);
//         newHead.next = null; // we don't need to add this line, since all object will be initialized to null
        
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
