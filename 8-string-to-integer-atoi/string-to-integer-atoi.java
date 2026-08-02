class Solution {
    public int myAtoi(String s) {
        StringBuilder sb=new StringBuilder();
        int sign =1;
        int found=0;
        int found1=0;
        // s.trim("\\s+");
        // if(s.charAt(0)=='-'){
        //     sign =-1;
        // }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                if(c=='0'&&found==0){
                    found1=1;
                    continue;
                }
                else if(Character.isDigit(c)){
                    found1=1;
                    found=1;
                    sb.append(c);
                }
            }
            else if(found==0&&c=='+'&&found1==0){
                found1=1;
                continue;
            }
            else if(found==0&&c==' '&&found1==0){
                continue;
            }
            else if(found==0&&c=='-'&&found1==0){
                found1=1;
                sign=-1;
                continue;
            }
            else{
                break;
            }
        }
        if(sb.length()==0){
            return 0;
        }
        String sb1=sb.toString();
        System.out.println(sb1);
        long x=0;
        if (sb1.length() > 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        for(int i=0;i<sb1.length();i++){
            int digit=sb1.charAt(i)-'0';
            x=x*10+digit;
        }
        x=x*sign;
        // long x = Long.parseLong(sb1.toString()) * sign;
        
        // // Clamp to 32-bit integer limits
        if (x > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (x < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)x;
        // return (int) x;
    }
}