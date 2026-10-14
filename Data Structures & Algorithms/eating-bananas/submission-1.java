class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
          int res = max;
        while (min <= max) {
            int k = min + (max - min) / 2;
            if (eatable(piles, k, h)) {
                res = k;
                max = k - 1;
            } else {
                min = k + 1;
            }
        }
        return res;
    }
    boolean eatable(int[] piles, int k, int h) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / k;
            if (piles[i] % k != 0) {
                hours++;
            }
        }

        if (hours <= h) {
            return true;
        } else {
            return false;
        }
    }
}
