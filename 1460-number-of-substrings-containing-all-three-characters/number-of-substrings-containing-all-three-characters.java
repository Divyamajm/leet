class Solution {
    public int numberOfSubstrings(String s) {
        int[] array=new int[3];
        int l=0;
        int total=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int rchar=s.charAt(i)-'a';
            array[rchar]++;
            while(array[0]!=0&&array[1]!=0&&array[2]!=0){
                total+=n-i;
                int lchar=s.charAt(l)-'a';
                array[lchar]--;
                l++;
            }
        }
        return total;
    }
}