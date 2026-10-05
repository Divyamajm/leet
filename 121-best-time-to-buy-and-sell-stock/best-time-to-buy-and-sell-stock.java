class Solution {
    public int maxProfit(int[] prices) {
        int max2=Integer.MIN_VALUE;
        int diff=0;
        int max1=Integer.MIN_VALUE;
        int n=prices.length;
        for(int i=n-1;i>=0;i--){
            max1=Math.max(max1,prices[i]);
            diff=max1-prices[i];
            max2=Math.max(max2,diff);
        }
        return max2;
    }
}