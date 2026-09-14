class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int mx = 0;
        int l = 0, r = 0;
        Set<Character> u = new HashSet();
        while (r < s.length()) {
            if (u.add(s.charAt(r))) {
                int diff = r - l;
                mx = Math.max(diff, mx);
                r++;
            } else {
                while (s.charAt(l) != s.charAt(r) && l <= r) {
                    u.remove(s.charAt(l));
                    l++;
                }
                l++;
                r++;
            }
        }

        return ++mx;
    }
}
