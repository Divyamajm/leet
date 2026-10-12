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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode before=dummy;
        for(int i=1;i<left;i++){
            before=before.next;
        }
        ListNode reverse=before.next;
        ListNode prev=null;
        ListNode slow=before.next;
        ListNode nxt=null;
        for(int i=0;i<=right-left;i++){
            nxt=slow.next;
            slow.next=prev;
            prev=slow;
            slow=nxt;
        }
        before.next=prev;
        reverse.next=slow;
        return dummy.next;
    }
}