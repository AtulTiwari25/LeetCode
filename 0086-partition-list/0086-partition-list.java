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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(); ListNode dummyLess = less;
        ListNode more = new ListNode(); ListNode dummyMore = more;
        while (head != null) {
            if (head.val < x) {
                dummyLess.next = head;
                dummyLess = dummyLess.next;
            } else {
                dummyMore.next = head;
                dummyMore = dummyMore.next;
            }
            head = head.next;
        }

        dummyLess.next = more.next;
        dummyMore.next = null;
        return less.next;
    }
}