class Solution {
    public int numberOfSubstrings(String s) {
        int[] array=new int[3];
        int l=0;
        int total=0;
        for(int i=0;i<s.length();i++){
            array[s.charAt(i)-'a']++;
            while(array[0]!=0&&array[1]!=0&&array[2]!=0){
                total+=s.length()-i;
                array[s.charAt(l)-'a']--;
                l++;
            }
        }
        return total;
    }
}