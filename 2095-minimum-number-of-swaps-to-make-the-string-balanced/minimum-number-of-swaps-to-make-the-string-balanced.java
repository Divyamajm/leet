class Solution {
    public int minSwaps(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='['){
                count++;
            }
            else{
                if(count>0){
                    count--;
                }
            }
        }
        return (count+1)/2;
    }
}