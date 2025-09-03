/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null ) return head;

        // Get length and tail
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k %= len;
        if (k == 0) return head;

        // Find new head
        ListNode curr = head;
        for (int i = 1; i < len - k; i++) curr = curr.next;

        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;

        return newHead;
    }
}
