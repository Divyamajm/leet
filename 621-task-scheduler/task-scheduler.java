class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer>map=new HashMap<>();
        PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        q.addAll(map.values());
        int task=0;
        while(!q.isEmpty()){
            ArrayList<Integer>temp=new ArrayList<>();
            int cycleLength=n+1;
            int tasksDone=0;
            while(!q.isEmpty()&&cycleLength>0){
                int x=q.poll();
                x--;
                if(x>0){
                    temp.add(x);
                }
                cycleLength--;
                tasksDone++;
            }
            for(int f:temp){
                q.offer(f);
            }
            if(q.isEmpty()){
                task+=tasksDone;
            }
            else{
                task+=n+1;
            }
        }return task;
    }
}