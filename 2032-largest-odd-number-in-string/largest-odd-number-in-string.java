class Solution {
    public String largestOddNumber(String num) {
        int index=-1;
        StringBuilder sb=new StringBuilder();
        int n=num.length();
        for(int i=n-1;i>=0;i--){
            int x=num.charAt(i)-'0';
            if(x%2==1){
                index=i;
                break;
            }
        }
        if(index==-1){
            return new String();
        }
        return num.substring(0,index+1);
    }
}