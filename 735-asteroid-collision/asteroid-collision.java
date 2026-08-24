class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer>s=new Stack();
        for(int i=0;i<n;i++){
            boolean alive=true;
            while(!s.isEmpty()&&s.peek()>0&&asteroids[i]<0){
                if(Math.abs(s.peek())<Math.abs(asteroids[i])){
                    s.pop();
                    continue;
                }
                else if(Math.abs(s.peek())==Math.abs(asteroids[i])){
                    s.pop();
                    alive=false;
                    break;
                }
                else{
                    alive=false;
                    break;
                }
            }
            if(alive==true){
                s.push(asteroids[i]);
            }
        }
        int[] result=new int[s.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i]=s.pop();
        }
        return result;
    }
}