class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer>q=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        while(n>0){
            int digit=n%10;
            q.offer(digit);
            n=n/10;
        }
        int x=q.poll();
        x=x*q.poll();
        return x;
    }
}