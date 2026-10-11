class LRUCache {
    Map<Integer, Integer> map = new HashMap();
    List<LRUPair> queue = new LinkedList();
    final int cap;
    public LRUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(new LRUPair(key, 0));
            queue.add(new LRUPair(key, System.currentTimeMillis()));
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(new LRUPair(key, 0));
            queue.add(new LRUPair(key, System.currentTimeMillis()));
            map.put(key,value);
        } else {
            map.put(key, value);
            queue.add(new LRUPair(key, System.currentTimeMillis()));
            if (queue.size() > cap) {
                LRUPair lru = queue.removeFirst();
                map.remove(lru.key);
            }
        }
    }

    class LRUPair {
        int key;
        long time;
        LRUPair(int k, long t) {
            key = k;
            time = t;
        }
        public int hashCode() {
            return key;
        }
        public boolean equals(Object o) {
            LRUPair l = (LRUPair) o;
            return this.key == l.key;
        }
    }
}
