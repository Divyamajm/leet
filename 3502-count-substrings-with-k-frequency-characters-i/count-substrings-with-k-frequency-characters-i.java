class Solution {
    public int numberOfSubstrings(String s, int k) {
        int l=0;
        int r=0;
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap();
        int total=0;
        while(r<n){
            char c=s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.getOrDefault(c,0)==k){
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
// abcabg
// 6-3+1
// 2
// abacb
// 3
