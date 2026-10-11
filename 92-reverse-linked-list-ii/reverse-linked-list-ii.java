class Solution {
    // This tracks the node immediately after the 'right' index
    // so we can reconnect it to the tail of our reversed sublist.
    ListNode successor = null; 

    // Helper function to reverse the first 'n' nodes
    private ListNode reverseFirstN(ListNode head, int n) {
        if (n == 1) {
            // Record the node that comes AFTER our reversed sublist
            successor = head.next;
            return head;
        }
        
        ListNode last = reverseFirstN(head.next, n - 1);
        head.next.next = head;
        // Connect the reversed part to the un-reversed rest of the list
        head.next = successor; 
        
        return last;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Base case: If we've reached the start of the sublist, reverse the next (right) nodes
        if (left == 1) {
            return reverseFirstN(head, right);
        }
        
        // Move forward until we hit the 'left' index
        head.next = reverseBetween(head.next, left - 1, right - 1);
        
        return head;
    }
}