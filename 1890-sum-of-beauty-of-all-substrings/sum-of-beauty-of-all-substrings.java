class Solution {
    public int beautySum(String s) {
        int total=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            HashMap<Character,Integer>map=new HashMap();
            for(int j=i;j<n;j++){
                char c=s.charAt(j);
                map.put(c,map.getOrDefault(c,0)+1);
                int min=Integer.MAX_VALUE;
                int max=0;
                for(int x:map.values()){
                    max=Math.max(max,x);
                    if(x>0){
                        min=Math.min(min,x);
                    }
                }
                total+=max-min;
            }
        }
        return total;
    }
}