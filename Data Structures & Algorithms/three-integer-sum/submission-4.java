class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (pre == nums[i]) {
                continue;
            } else {
                pre = nums[i];
            }
            int ts = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == ts) {
                    List<Integer> triplet = new ArrayList();
                    triplet.add(nums[i]);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);
                    res.add(triplet);
                    int lnum = nums[l];
                    int rnum = nums[r];
                    while (lnum == nums[l] && l < r) l++;
                    while (rnum == nums[r] && l < r) r--;

                } else if (nums[l] + nums[r] < ts) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
