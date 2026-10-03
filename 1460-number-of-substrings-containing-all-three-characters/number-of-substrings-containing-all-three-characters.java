class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer>map=new HashMap();
        int l=0;
        int r=0;
        int total=0;
        int n=s.length();
        while(r<n){
            char c=s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()==3){
                total+=n-r;
                char lchar=s.charAt(l);
                map.put(lchar,map.get(lchar)-1);
                if(map.get(lchar)==0){
                    map.remove(lchar);
                }
                l++;
            }
            r++;
        }
        return total;
    }
}