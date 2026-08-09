import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(map.values());
        
        int totalTime = 0;
        
        // Simpler Engine: Process in blocks of (n + 1)
        while (!maxHeap.isEmpty()) {
            
            List<Integer> waitingRoom = new ArrayList<>();
            int cycleLength = n + 1;
            int tasksDoneThisCycle = 0;
            
            // 1. Pull as many unique tasks as possible for this cycle
            while (cycleLength > 0 && !maxHeap.isEmpty()) {
                int freq = maxHeap.poll();
                freq--;
                
                if (freq > 0) {
                    waitingRoom.add(freq);
                }
                
                tasksDoneThisCycle++;
                cycleLength--;
            }
            
            // 2. Dump everything from the waiting room back into the heap
            for (int freq : waitingRoom) {
                maxHeap.offer(freq);
            }
            
            // 3. Add time
            if (maxHeap.isEmpty()) {
                // The heap is empty! We are completely done. 
                // Only add the tasks we actually did, no trailing idle time.
                totalTime += tasksDoneThisCycle; 
            } else {
                // There are still tasks left, which means the whole (n + 1) block passed
                // (including any idle time if we ran out of unique tasks this cycle).
                totalTime += (n + 1); 
            }
        }
        
        return totalTime;
    }
}