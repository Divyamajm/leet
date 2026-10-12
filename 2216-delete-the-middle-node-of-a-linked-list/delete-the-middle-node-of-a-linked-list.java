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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode temp=null;
        if(head==null||head.next==null){
            return temp;
        }
        // int count=1;
        while(fast!=null&&fast.next!=null){
            temp=slow;
            slow=slow.next;
            // count++;
            fast=fast.next.next;
        }
        temp.next=slow.next;
        return head;
    }
}