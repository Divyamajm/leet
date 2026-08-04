class Solution {
    public int beautySum(String s) {
        int total=0;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer>map=new HashMap<>();
            // total=0;
            for(int j=i;j<s.length();j++){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                int max=0;
                int min=Integer.MAX_VALUE;
                for(int count:map.values()){
                    if(count>0){
                        max=Math.max(max,count);
                        min=Math.min(min,count);
                    }
                    // System.out.print(max,min);
                }

                total+=max-min;
            }
        }return total;
    }
}