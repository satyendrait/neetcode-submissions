class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int longest = 0;
        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 0) {
            } else if (nums[i] - nums[i - 1] == 1) {
                curr++;
            } else {
                if (curr > longest) {
                    longest = curr;
                }
                curr = 1;
            }
        }
        if (curr > longest) {
            longest = curr;
        }
        return longest;
    }
}
