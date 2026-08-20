class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        Arrays.fill(arr1,Integer.MIN_VALUE);
        Arrays.fill(arr2,Integer.MIN_VALUE);
        Stack<Integer>s1=new Stack();
        Stack<Integer>s2=new Stack();
        s1.push(nums[0]);
        s2.push(nums[1]);
        arr1[0]=nums[0];
        arr2[0]=nums[1];
        int x=1;
        int y=1;
        for(int i=2;i<nums.length;i++){
            if(s1.peek()>=s2.peek()){
                arr1[x++]=nums[i];
                s1.push(nums[i]);
            }
            else{
                arr2[y++]=nums[i];
                s2.push(nums[i]);
            }
        }
        int l=0;
        int r=0;
        for(int i=0;i<n;i++){
            if(arr1[i]==Integer.MIN_VALUE){
                l=i;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(arr2[i]==Integer.MIN_VALUE){
                r=i;
                break;
            }
        }
        for(int i=0;i<l;i++){
                nums[i]=arr1[i];
            }
        for(int i=0;i<r;i++){
            nums[l+i]=arr2[i];
        // }
        // int l=arr1.length;
        // int r=arr2.length;
        // if(arr1[l-1]<arr2[r-1]){
            
        // }
        // else{
        //     for(int i=0;i<r;i++){
        //         nums[i]=arr2[i];
        //     }
        //     for(int i=0;i<l;i++){
        //         nums[r+i]=arr1[i];
        //     }
        }return nums;
    }
}