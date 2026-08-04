class Solution {
    public int beautySum(String s) {
        int total=0;
        for(int i=0;i<s.length();i++){
            int[] freq=new int[26];
            // total=0;
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                int max=0;
                int min=Integer.MAX_VALUE;
                for(int count:freq){
                    if(count>0){
                        max=Math.max(max,count);
                        min=Math.min(min,count);
                    }
                    // System.out.print(max,min);
                }

                total+=max-min;
            }
        }return total;
    }
}