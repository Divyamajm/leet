class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        int l=0;
        int r=0;
        int n=s.length()-1;
        int ind=0;
        int count=0;
        int minLength=Integer.MAX_VALUE;
        while(r<=n){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r))+1);
                if(map.get(s.charAt(r))<=0){
                    count++;
                }
            }
            while(count==t.length()){
                if(minLength>r-l+1){
                    minLength=r-l+1;
                    ind=l;
                }
                if(map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l),map.get(s.charAt(l))-1);
                    if(map.get(s.charAt(l))<0){
                        count--;
                    }
                }
                l++;
            }
            r++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(ind, ind + minLength);
    }
}