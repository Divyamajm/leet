class Solution {
    public ListNode doubleIt(ListNode head) {
        
        // --- PHASE 1: REVERSE THE ORIGINAL LIST ---
        ListNode prev = null;
        ListNode nxt = null;
        ListNode curr = head;
        while(curr != null){ // FIXED: changed 'rev' to 'curr'
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        // At this point, 'prev' is the new head of the reversed list.
        
        // --- PHASE 2: DOUBLE THE VALUES ---
        ListNode temp = prev; // FIXED: Start at 'prev', not 'head'
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while(temp != null){
            int total = carry;
            total += temp.val * 2;
            carry = total / 10;
            ListNode temp1 = new ListNode(total % 10);
            current.next = temp1;
            current = current.next;
            temp = temp.next;
        }
        
        if(carry > 0){
            ListNode carry1 = new ListNode(carry);
            current.next = carry1;
        }
        
        // --- PHASE 3: REVERSE THE NEW RESULT LIST ---
        // We reuse the same pointer names, but apply them to 'dummy.next'
        prev = null;
        nxt = null;
        curr = dummy.next; 
        
        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        
        // 'prev' is now the head of our final, correctly ordered list
        return prev;
    }
}