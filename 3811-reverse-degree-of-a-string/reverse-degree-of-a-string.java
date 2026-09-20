class Solution {
    public int reverseDegree(String s) {
        int total=0;
        for(int i=0;i<s.length();i++){
            total+=(i+1)*(int)(1+Math.abs(s.charAt(i)-'z'));
            System.out.println(total);
        }
        return total;
    }
}