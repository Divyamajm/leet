class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int n=s.length();
        int max=0;
        HashMap<Character,Integer>map=new HashMap();
        while(r<n){
            char rchar=s.charAt(r);
            while(map.containsKey(rchar)){
                char lchar=s.charAt(l);
                map.put(lchar,map.get(lchar)-1);
                if(map.get(lchar)==0){
                    map.remove(lchar);
                }
                l++;
            }
            max=Math.max(max,r-l+1);
            map.put(rchar,map.getOrDefault(rchar,0)+1);
            r++;
        }
        return max;
    }
}