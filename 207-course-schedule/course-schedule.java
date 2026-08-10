class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        int[]inDegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer>topo=new ArrayList<>();
        while(!q.isEmpty()){
            int r=q.poll();
            topo.add(r);
            for(int it:adj.get(r)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(topo.size()!=numCourses){
            return false;
        }
        return true;
    }
}