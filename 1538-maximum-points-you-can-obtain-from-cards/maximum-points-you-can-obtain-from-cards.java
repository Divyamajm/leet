class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total=0;
        int n=cardPoints.length;
        for(int i=0;i<k;i++){
            total+=cardPoints[i];
        }
        int x=k;
        int maxTotal=total;
        for(int i=0;i<k;i++){
            total+=cardPoints[n-i-1];
            total-=cardPoints[x-1];
            x--;
            maxTotal=Math.max(maxTotal,total);
        }return maxTotal;
    }
}