class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> groups = new LinkedHashMap();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] sChar = str.toCharArray();
            Arrays.sort(sChar);
            String key = new String(sChar);
            groups.putIfAbsent(key, new ArrayList());
            List<Integer> list = groups.get(key);
            list.add(i);
            groups.put(key, list);
        }
        List<List<String>> result = new ArrayList();
        for (String str : groups.keySet()) {
            List<String> sub = new ArrayList();
            for (Integer idx : groups.get(str)) {
                sub.add(strs[idx]);
            }
            result.add(sub);
        }
        return result;
    }
}
