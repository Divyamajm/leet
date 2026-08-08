class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer>q=new PriorityQueue<>((a,b)->{
            int dist1=Math.abs(b-x);
            int dist2=Math.abs(a-x);
            if(dist1==dist2){
                return Integer.compare(b,a);
            }
            return Integer.compare(dist1,dist2);
            });
        for(int i=0;i<arr.length;i++){
            q.offer(arr[i]);
            if(q.size()>k){
                q.poll();
            }
        }
        ArrayList<Integer>result=new ArrayList<>();
        for(int i=0;i<k;i++){
            result.add(q.poll());
        }
        Collections.sort(result);
        return result;
    }
}