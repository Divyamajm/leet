class Solution {
    public int value(char c){
        if(c=='I'){
            return 1;
        }
        else if(c=='V'){
            return 5;
        }
        else if(c=='X'){
            return 10;
        }
        else if(c=='L'){
            return 50;
        }
        else if(c=='C'){
            return 100;
        }
        else if(c=='D'){
            return 500;
        }
        else{
            return 1000;
        }
        // return 0;
    }
    public int romanToInt(String s) {
        int total=value(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--){
            if(value(s.charAt(i))<value(s.charAt(i+1))){
                total=total-value(s.charAt(i));
            }
            else{
                total=total+value(s.charAt(i));
            }
        }
        return total;
    }
}