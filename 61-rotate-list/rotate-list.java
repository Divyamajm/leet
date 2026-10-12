class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases: empty list, single node, or no rotations needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Find the length of the list and the current tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Connect the tail to the head to form a circle!
        tail.next = head;

        // 3. Calculate effective rotations
        k = k % length;
        
        // 4. Find the new tail. 
        // If we rotate right by k, the new tail is at index (length - k - 1)
        int stepsToNewTail = length - k;
        ListNode newTail = tail; 
        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        // 5. The new head is right after the new tail. Break the circle!
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}