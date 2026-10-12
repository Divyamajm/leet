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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;
        // int total=0;
        while(l1!=null||l2!=null){
            int total=carry;
            if(l1!=null){
                total+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                total+=l2.val;
                l2=l2.next;
            }
            carry=total/10;
            // total=;
            ListNode temp=new ListNode(total%10);
            current.next=temp;
            current=current.next;
        }
        if(carry>0){
            ListNode carry1=new ListNode(carry);
            current.next=carry1;
        }
        return dummy.next;
    }
}