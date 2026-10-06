class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set=new HashSet();
        int l=0;
        int r=0;
        int n=s.length();
        int max=0;
        // Has
        while(r<n){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}