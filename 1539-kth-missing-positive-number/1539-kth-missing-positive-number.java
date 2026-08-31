class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo =0;
        int n =arr.length;
        int hi=n-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            int actualNumber = arr[mid];
            int expectedNumber = mid+1;
            int missingNumber = actualNumber - expectedNumber;
            if(missingNumber>=k){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return lo+k;
    }
}