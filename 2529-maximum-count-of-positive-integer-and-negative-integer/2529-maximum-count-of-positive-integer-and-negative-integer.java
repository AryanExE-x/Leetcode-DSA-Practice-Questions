class Solution {

    public int maximumCount(int[] nums) {
        return Math.max(positiveInt(nums), negativeInt(nums));
    }

    public int positiveInt(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] > 0)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return arr.length - lo;
    }

    public int negativeInt(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] >= 0)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return lo;
    }
}