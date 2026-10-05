class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        Map<Character, Integer> s1Map = new HashMap();
        Map<Character, Integer> s2Map = new HashMap();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1Map.putIfAbsent(c, 0);
            s1Map.put(c, s1Map.get(c) + 1);
        }

        int l = 0, r = 0;
        while (r < s1.length()) {
            char c = s2.charAt(r);
            s2Map.putIfAbsent(c, 0);
            s2Map.put(c, s2Map.get(c) + 1);
            r++;
        }
        r--;
        while (r < (s2.length() - 1)) {
            if (isPer(s1Map, s2Map)) {
                return true;
            }
            char lc = s2.charAt(l);
            l++;
            r++;
            char rc = s2.charAt(r);
            s2Map.put(lc, s2Map.get(lc) - 1);
            s2Map.putIfAbsent(rc, 0);
            s2Map.put(rc, s2Map.get(rc) + 1);
        }
        if (isPer(s1Map, s2Map)) {
            return true;
        }
        return false;
    }

    boolean isPer(Map<Character, Integer> s1, Map<Character, Integer> s2) {
        for (Map.Entry<Character, Integer> entry : s1.entrySet()) {
            if (s2.containsKey(entry.getKey()) && s2.get(entry.getKey()) == entry.getValue()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
