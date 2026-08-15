class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character>map=new HashMap<>();
        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        for(int i=0;i<s1.length;i++){
            if(map.containsKey(s1[i])&&map.get(s1[i])!=s2[i]){
                return false;
            }
            else if(!map.containsKey(s1[i])&&map.containsValue(s2[i])){
                return false;
            }
            map.put(s1[i],s2[i]);
        }
        return true;
    }
}