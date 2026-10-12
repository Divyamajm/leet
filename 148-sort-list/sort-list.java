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
    public ListNode sortList(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        temp=head;
        int[] array=new int[count];
        int j=0;
        while(temp!=null){
            array[j++]=temp.val;
            temp=temp.next;
        }
        Arrays.sort(array);
        // ListNode dummy=new ListNode(-1);
        // ListNode dummyHead=dummy;
        temp=head;
        for(int i=0;i<count;i++){
            temp.val=array[i];
            temp=temp.next;
        }
        return head;
    }
}