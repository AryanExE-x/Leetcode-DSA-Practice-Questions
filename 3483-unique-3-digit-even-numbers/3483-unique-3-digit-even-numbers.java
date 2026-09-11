class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;

        for (int num = 100; num <= 998; num++) {

            // Number must be even
            if (num % 2 != 0)
                continue;

            int a = num / 100;        // hundreds
            int b = (num / 10) % 10;  // tens
            int c = num % 10;         // units

            // Check if we can use a, b, c from digits
            int[] freq = new int[10];

            for (int d : digits)
                freq[d]++;

            if (freq[a] > 0) {
                freq[a]--;

                if (freq[b] > 0) {
                    freq[b]--;

                    if (freq[c] > 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}