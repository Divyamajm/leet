class Solution {
    public int numberOfSubstrings(String s) {
        int l=0;
        int r=0;
        int n=s.length()-1;
        int total=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(r<=n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()==3){
                total+=n-r+1;
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            r++;
        }
        return total;
    }
}