class Solution {
    public int numberOfSubstrings(String s) {
        int[] array=new int[3];
        // Arrays.fill(array,-1);
        int n=s.length();
        int total=0;
        int x=0;
        for(int i=0;i<n;i++){
            array[s.charAt(i)-'a']++;
            while(array[0]>0&&array[1]>0&&array[2]>0){
                total+=n-i;
                array[s.charAt(x)-'a']--;
                x++;
            }
        }return total;
    }
}