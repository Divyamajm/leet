class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int l=0;
        int r=0;
        int maxLength=0;
        int n=fruits.length-1;
        while(r<=n){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            while(map.size()>2){
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            maxLength=Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
    }
}