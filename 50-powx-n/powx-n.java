class Solution {
    public double myPow(double x, int n) {
        double power=n;
        if(n<0){
            x=1/x;
            power=-power;
        }
        double ans=1.0;
        while(power>0){
            if(power%2==1){
                ans*=x;
                power--;
            }
            else{
                x=x*x;
                power=power/2;
            }
        }
        // if(apowers>Ipowerteger.MAX_VALUE){
        //     returpower 0;
        // }
        // if(apowers<Ipowerteger.MIpower_VALUE){
        //     returpower 0;
        // }
        return ans;
    }
}