class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer>count=new HashSet<>();
        for(int j=0;j<nums.length;j++){
            int total=nums[j];
            // for(int i=0;i<nums.length;i++){
            //     total*=nums[i];
            // }
            // int count=0;
            if(total%2==0){
                count.add(2);
                while(total%2==0){
                    total/=2;
                }
            }
            for(int i=3;i*i<=total;i+=2){
                if(total%i==0){
                    count.add(i);
                    while(total%i==0){
                        total/=i;
                    }
                }
            }
            if(total>2){
                count.add(total);
            }
            
        }
        // int total=1;
        // for(int i=0;i<nums.length;i++){
        //     total*=nums[i];
        // }
        // int count=0;
        // if(total%2==0){
        //     count++;
        //     while(total%2==0){
        //         total/=2;
        //     }
        // }
        // for(int i=3;i*i<total;i+=2){
        //     if(total%i==0){
        //         count++;
        //         while(total%i==0){
        //             total/=i;
        //         }
        //     }
        // }
        // if(total>2){
        //     count++;
        // }
        // return count;
        return count.size();
    }
}