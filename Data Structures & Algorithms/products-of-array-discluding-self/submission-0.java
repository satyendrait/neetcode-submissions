class Solution {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                product *= nums[i];
            }
        }

        int[] res = new int[nums.length];
        if (zeros > 1) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeros > 0) {
                if (nums[i] == 0) {
                    res[i] = (int) product;
                } else {
                    res[i] = 0;
                }
            } else {
                res[i] = (int) product / nums[i];
            }
        }
        return res;
    }
}
