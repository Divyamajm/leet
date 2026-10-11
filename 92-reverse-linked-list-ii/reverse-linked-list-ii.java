import java.util.Stack;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 1. Traverse to the node immediately before the 'left' index
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // 2. Push all nodes from 'left' to 'right' onto the stack
        ListNode curr = prev.next;
        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i <= right - left; i++) {
            stack.push(curr);
            curr = curr.next;
        }

        // 'curr' is now sitting on the node immediately AFTER 'right' (the successor)
        ListNode successor = curr; 

        // 3. Pop nodes off the stack and re-link them. 
        // Because it's a stack, they come out in reverse order!
        while (!stack.isEmpty()) {
            prev.next = stack.pop();
            prev = prev.next; // Move our pointer forward
        }

        // 4. Connect the tail of our newly reversed sublist to the rest of the list
        prev.next = successor;

        return dummy.next;
    }
}