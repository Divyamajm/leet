class Solution {
    public int smallestNumber(int n, int t) {
        boolean found=true;
        
        while(found==true){
            int n1=n;
            int total=1;
            while(n1>0){
                int digit=n1%10;
                total*=digit;
                n1=n1/10;
            }
            if(total%t==0){
                found=false;
            }
            else{
                n++;
                // n=n1;
            }
        }return n;
    }
}