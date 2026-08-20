class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>map=new HashMap<>();
        int l=0;
        int r=0;
        int n=s.length()-1;
        int maxLength=0;
        int maxCount=0;
        while(r<=n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            maxCount=Math.max(maxCount,map.get(s.charAt(r)));
            if(r-l+1-maxCount>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            maxLength=Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
    }
}