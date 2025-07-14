
class Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num = (num << 1) | head.val; // Bitwise shift left and OR with current bit
            head = head.next;
        }
        return num;
    }
}