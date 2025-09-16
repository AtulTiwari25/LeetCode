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
    public ListNode deleteDuplicates(ListNode head) {
      if(head==null||head.next==null){
        return head;
      }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode current=dummy.next;
        ListNode prev=dummy;
        while(current!=null&&current.next!=null){
            if(current.val==current.next.val){
             ListNode temp=current;
             while(temp.next.val==current.val){
               temp=temp.next;
               if(temp.next==null){
                break;
               }

             }
            prev.next=temp.next;
            current=prev.next;


            }
           else{
             prev=current;
            current=current.next;
           }

        }
        return dummy.next;
    }
}