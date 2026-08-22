class Solution {
    public boolean checkDivisibility(int n) {
        int x=n;
        int sum=1;
        int total=0;
        while(n>0){
            int digit=n%10;
            total+=digit;
            sum*=digit;
            n=n/10;
        }
        System.out.println(sum+" "+total);
        if(x%(sum+total)==0){
            return true;
        }
        return false;
    }
}