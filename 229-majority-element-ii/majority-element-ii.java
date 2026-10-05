class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer>list=new ArrayList();
        int n=nums.length;
        int total1=0;
        int total2=0;
        int count1=0;
        int count2=0;
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(count1==0&&nums[i]!=el2){
                count1=1;
                el1=nums[i];
            }
            else if(count2==0&&nums[i]!=el1){
                count2=1;
                el2=nums[i];
            }
            else if(nums[i]==el1){
                count1++;
            }
            else if(nums[i]==el2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]==el1){
                total1++;
                
            }
            else if(nums[i]==el2){
                total2++;
                
            }
        }
        if(total1>n/3){
                    list.add(el1);
                }
                if(total2>n/3){
                    list.add(el2);
                }
        return list;
    }
}