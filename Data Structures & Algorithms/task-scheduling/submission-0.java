class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : tasks) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Max-heap to store the frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(counts.values()); // Fixed the stream compilation issue

        Queue<Pair> q = new LinkedList<>();
        int cycle = 0;

        // ERROR FIX 1: Change to OR (||) so it keeps running if tasks remain
        while (!pq.isEmpty() || !q.isEmpty()) {
            cycle++;

            // Bring tasks out of cool-down if their wait time is up
            if (!q.isEmpty() && q.peek().time == cycle) {
                Pair p = q.remove();
                pq.add(p.count);
            }

            // Execute the highest frequency task available
            if (!pq.isEmpty()) {
                int c = pq.remove();
                if (c > 1) {
                    q.add(new Pair(c - 1, cycle + n + 1));
                }
            }
        }
        return cycle;
    }

    record Pair(int count, int time) {}
}