class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer>map=new HashMap();
        int l=0;
        int r=0;
        int n=fruits.length;
        int max=0;
        while(r<n){
            int c=fruits[r];
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()>2 && l<r){
                int d=fruits[l];
                map.put(d,map.get(d)-1);
                if(map.get(d)==0){
                    map.remove(d);
                }
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}