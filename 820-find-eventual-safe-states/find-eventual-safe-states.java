class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj=new ArrayList<>();
        List<Integer> topo=new ArrayList<>();
        int n=graph.length;
        int m=graph[0].length;
        int[] inDegree=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        // for(int grap[]:graph){
        //     int u=grap[0];
        //     int v=grap[1];
        //     adj.get(u).add(v);
        //     // adj.get(v).add(u);
        //     inDegree[u]++;
        // }
        for(int i=0;i<n;i++){
            for(int it:graph[i]){
                adj.get(it).add(i);
                inDegree[i]++;
            }
        }
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            topo.add(curr);
            for(int it:adj.get(curr)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(topo);
        return topo;
    }
}