class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Distance> pq =
            new PriorityQueue<Distance>(Comparator.comparingDouble(Distance::d));
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double d = Math.sqrt(Math.pow(x - 0, 2) + Math.pow(y - 0, 2));
            pq.add(new Distance(d, x, y));
        }
        for (int[] r : res) {
            Distance d = pq.remove();
            r[0] = d.x;
            r[1] = d.y;
        }
        return res;
    }
    record Distance(double d, int x, int y) {}
}
