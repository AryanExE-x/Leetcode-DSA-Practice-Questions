class Solution {
    public int smallestIndex(int[] nums) {
        int smallest=Integer.MAX_VALUE;
        int i;
        for(i=0;i<nums.length;i++){
            if(sumDigit(nums[i])==i && (nums[i])<=smallest){
                    return i;
      
            }
        }
        return -1;


    }
    public int sumDigit(int num){
        int sum=0;
        while(num!=0){
            int lastDigit=num%10;
            sum+=lastDigit;
            num=num/10;
        }
        return sum;
    }
}