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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>q=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode head:lists){
            if(head!=null){
                q.offer(head);
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;
        while(!q.isEmpty()){
            ListNode small=q.poll();
            current.next=small;
            current=current.next;
            if(small.next!=null){
                q.offer(small.next);
            }
        }return dummy.next;
    }
}