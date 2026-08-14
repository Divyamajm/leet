class Solution {
    public int maximumLengthSubstring(String s) {
        int l=0;
        int r=0;
        int n=s.length()-1;
        int maxLength=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(r<=n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.get(s.charAt(r))>2){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            maxLength=Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
    }
}