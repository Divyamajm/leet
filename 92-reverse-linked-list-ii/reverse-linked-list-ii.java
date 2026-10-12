class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: No reversal needed
        if (head == null || left == right) {
            return head;
        }

        // Dummy node handles the case where left = 1 (head changes)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Phase 1: Reach the node just BEFORE the reversal zone
        ListNode beforeReverse = dummy;
        for (int i = 1; i < left; i++) {
            beforeReverse = beforeReverse.next;
        }
        
        // The first node in our reversal zone will end up at the very back.
        // We save it so we can connect it to the rest of the list later.
        ListNode reverseTail = beforeReverse.next;
        
        // Phase 2: Standard Reversal Loop (but limited to right - left + 1 nodes)
        ListNode prev = null;
        ListNode curr = beforeReverse.next;
        ListNode nxt = null;
        
        for (int i = 0; i <= right - left; i++) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        
        // Phase 3: Reconnect the ends
        // 'prev' is now the new head of the reversed sublist
        beforeReverse.next = prev; 
        
        // 'curr' is now sitting on the first node AFTER the reversed sublist
        reverseTail.next = curr;   
        
        return dummy.next;
    }
}