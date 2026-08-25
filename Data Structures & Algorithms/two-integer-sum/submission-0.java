class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idx = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (idx.containsKey(diff)) {
                int first = idx.get(diff);
                return new int[] {first, i};
            } else {
                idx.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
