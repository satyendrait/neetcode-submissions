class TimeMap {
    Map<String, List<Pair>> map = new HashMap();
    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair> values = map.get(key);
        String res = "";
        if (values == null)
            return res;
        int l = 0, r = values.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (values.get(mid).timestamp == timestamp)
                return values.get(mid).val;
            if (values.get(mid).timestamp <= timestamp) {
                res = values.get(mid).val();
                l=mid+1;
            } else {
                r = mid-1;
            }
        }

        return res;
    }

    record Pair(int timestamp, String val) {}
}
