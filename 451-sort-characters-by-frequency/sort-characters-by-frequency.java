class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        char[] s2=s.toCharArray();
        Arrays.sort(s2);
        int n=s2.length;
        for(int i=0;i<n;i++){
            map.put(s2[i],map.getOrDefault(s2[i],0)+1);
        }
        PriorityQueue<Character> q=new PriorityQueue<>((a,b)->Integer.compare(map.get(b),map.get(a)));
        q.addAll(map.keySet());
        // Arrays.sort(s2);
        while(!q.isEmpty()){
            char c=q.poll();
            int y=map.get(c);
            for(int i=0;i<y;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}