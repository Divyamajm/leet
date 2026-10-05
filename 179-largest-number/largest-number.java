class Solution {
    public String largestNumber(int[] nums) {
        String[] s=new String[nums.length];
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            s[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(s,(b,a)->{
            String first=a+b;
            String second=b+a;
            return first.compareTo(second);
        });
        if(s[0].equals("0")){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(s[i]);
        }
        return sb.toString();
    }
}