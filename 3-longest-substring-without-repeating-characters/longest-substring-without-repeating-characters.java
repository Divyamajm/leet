class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int l=0;
        int r=0;
        int n=s.length()-1;
        int maxLength=0;
        while(r<=n){
            if(map.containsKey(s.charAt(r))&&map.get(s.charAt(r))>=l){
                l=map.get(s.charAt(r))+1;
            }
            map.put(s.charAt(r),r);
            maxLength=Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
    }
}