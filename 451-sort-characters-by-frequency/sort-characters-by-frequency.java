class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer>map=new HashMap();
        PriorityQueue<Character>q=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(char c:map.keySet()){
            q.offer(c);
        }
        while(!q.isEmpty()){
            char c=q.poll();
            int x=map.get(c);
            for(int i=0;i<x;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}