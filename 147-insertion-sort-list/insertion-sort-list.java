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
    public ListNode insertionSortList(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int[] arr=new int[count];
        temp=head;
        int j=0;
        while(temp!=null){
            arr[j++]=temp.val;
            temp=temp.next;
        }
        temp=head;
        Arrays.sort(arr);
        for(int i=0;i<count;i++){
            temp.val=arr[i];
            temp=temp.next;
        }
        return head;
    }
}