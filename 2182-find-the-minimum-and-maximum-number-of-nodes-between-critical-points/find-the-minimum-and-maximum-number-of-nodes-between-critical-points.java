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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // A linked list must have at least 3 nodes to have any critical points
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstCritical = -1;
        int lastCritical = -1;
        int minDistance = Integer.MAX_VALUE;

        // Pointers to track previous, current, and index
        ListNode prev = head;
        ListNode curr = head.next;
        int currentIndex = 1; 

        while (curr.next != null) {
            ListNode nextNode = curr.next;

            // Check if current node is a local maxima OR local minima
            if ((curr.val > prev.val && curr.val > nextNode.val) || 
                (curr.val < prev.val && curr.val < nextNode.val)) {
                
                // If it's the very first critical point we've found
                if (firstCritical == -1) {
                    firstCritical = currentIndex;
                } else {
                    // Update the minimum distance using the previous critical point
                    minDistance = Math.min(minDistance, currentIndex - lastCritical);
                }
                
                // Update the last seen critical point index
                lastCritical = currentIndex;
            }

            // Move pointers forward
            prev = curr;
            curr = nextNode;
            currentIndex++;
        }

        // If we found fewer than 2 critical points, minDistance never changed
        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        // Max distance is always the difference between the absolute first and absolute last
        int maxDistance = lastCritical - firstCritical;
        
        return new int[]{minDistance, maxDistance};
    }
}