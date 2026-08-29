class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> mp = new HashMap();
        int longest = 0;
        for (int n : nums) {
            if (!mp.containsKey(n)) {
                mp.put(n, mp.getOrDefault(n - 1, 0) + mp.getOrDefault(n + 1, 0) + 1);
                mp.put(n - mp.getOrDefault(n - 1, 0), mp.get(n));
                mp.put(n + mp.getOrDefault(n + 1, 0), mp.get(n));
                longest = Math.max(longest, mp.get(n));
            }
        }

        return longest;
    }
}
