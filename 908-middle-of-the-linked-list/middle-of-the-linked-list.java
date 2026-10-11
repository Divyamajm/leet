class Solution {
    public ListNode middleNode(ListNode head) {
        // Base case is good
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // CORRECTED CONDITION: 
        // 1. fast != null (Protects even-length lists where fast jumps past the end)
        // 2. fast.next != null (Protects odd-length lists where fast lands on the last node)
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Moves 1 step
            fast = fast.next.next;    // Moves 2 steps
        }
        
        return slow;
    }
}