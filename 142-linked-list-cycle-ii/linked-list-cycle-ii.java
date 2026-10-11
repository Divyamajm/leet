/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode temp=new ListNode(-1);
        HashMap<ListNode,Integer>map=new HashMap();
        int count=0;
        int index=-1;
        int found=0;
        while(slow!=null){
            if(map.containsKey(slow)){
                return slow;
            }
            else{
                map.put(slow,count++);
            }
            slow=slow.next;
            // fast=fast.next.next;
            // if(slow==fast){
            //     found=1;
            // }
        }
        return null;
    }
}