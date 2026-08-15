class Solution {
    public int numberOfSubstrings(String s) {
        int l=0;
        int r=0;
        int total=0;
        int n=s.length()-1;
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<=n){
            char c=s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.size()==3){
                total+=n-r+1;
            }
            while(map.size()==3){
                char x=s.charAt(l);
                map.put(x,map.get(x)-1);
                if(map.get(x)==0){
                    map.remove(x);
                }
                else{
                    total+=n-r+1;
                }
                l++;
            }r++;
        }return total;
    }
}