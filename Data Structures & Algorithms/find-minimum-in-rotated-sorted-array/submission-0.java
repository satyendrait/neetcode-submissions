class Solution {
    public int findMin(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[idx] > nums[i]) {
                idx = i;
            }
        }
        return nums[idx];
    }
}