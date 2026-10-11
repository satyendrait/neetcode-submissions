class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> u = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (u.contains(nums[i])) {
                return nums[i];
            } else {
                u.add(nums[i]);
            }
        }
        return 0;
    }
}