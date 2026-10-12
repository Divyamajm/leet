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
        ListNode newHead=head;
        ListNode first=head;
        int count=0;
        if(head==null||k==0||head.next==null){
            return head;
        }
        while(first!=null){
            count++;
            first=first.next;
        }
        k=k%count;
        while(k>0){
            ListNode temp=head;
            ListNode prev=null;
            while(temp.next!=null){
                prev=temp;
                temp=temp.next;
            }
            temp.next=head;
            head=temp;
            prev.next=null;
            k--;
        }
        return head;
    }
}