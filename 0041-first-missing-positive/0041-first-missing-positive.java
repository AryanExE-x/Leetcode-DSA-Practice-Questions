class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        int n=nums.length;  
        while(i<n){
            int rightIdx=nums[i]-1;
            //negative | length se zyada | correct place | duplicate-swap pos.
            if(nums[i]<=0 || nums[i]>n || nums[i]==i+1 || nums[i]==nums[rightIdx])  i++;
            else swap(nums,i,rightIdx);
        }
        for(i=0;i<n;i++){
            if(nums[i]!= i+1) return i+1;
        }
        return n+1;
    }
    private void swap(int[] arr,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}