class Solution {
    public boolean canWinNim(int n) {
        if(n<=3){
            return true;
        }
        if(n%4==0){
            return false;
        }
        return true;
    }
}
// 1 2 3 4 5 6 7 8