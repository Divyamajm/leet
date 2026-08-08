class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]>q=new PriorityQueue<>((a,b)->Integer.compare(b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1]));
        // HashMap<int[],Integer>map=new HashMap<>();
        for(int i=0;i<points.length;i++){
            // int x=(int)(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
            // x=(int)Math.sqrt(x);
            // map.put(points[i],x);
            q.offer(points[i]);
            if(q.size()>k){
                q.poll();
            }
        }
        int[][] result=new int[k][2];
        for(int i=0;i<k;i++){
            result[i]=q.poll();
        }
        return result;
    }
}