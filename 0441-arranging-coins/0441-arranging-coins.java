class Solution {

    public long sqrt(long n) {

        if(n == 0) return 0;

        long lo = 1;
        long hi = n;

        while(lo <= hi) {

            long mid = lo + (hi - lo) / 2;

            if(mid == n / mid)
                return mid;

            else if(mid < n / mid)
                lo = mid + 1;

            else
                hi = mid - 1;
        }

        return hi;
    }

    public int arrangeCoins(int n) {

        long m = (long)n;

        return (int)((sqrt(8 * m + 1) - 1) / 2);
    }
}