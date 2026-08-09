class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        PriorityQueue<Character> q=new PriorityQueue<>((a,b)->Integer.compare(map.get(b),map.get(a)));
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder sb=new StringBuilder();
        for(char key:map.keySet()){
            q.offer(key);
        }
        Character waitingChar=null;
        int waitingCount=0;
        while(!q.isEmpty()){
            char x=q.poll();
            sb.append(x);
            map.put(x,map.get(x)-1);
            if(waitingChar!=null&&waitingCount>0){
                q.offer(waitingChar);
            }
            waitingChar=x;
            waitingCount=map.get(x);
        }
        if(sb.length()!=s.length()){
            return "";
        }
        return sb.toString();
    }
}