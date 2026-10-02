class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int frontCar = 0;
        Stack<Double> fleet = new Stack();
        List<Pair> pairs = new ArrayList();
        for (int i = 0; i < position.length; i++) {
            pairs.add(new Pair(position[i], speed[i]));
        }
        Collections.sort(pairs);
        for (int i = 0; i < position.length; i++) {
            Pair pair = pairs.get(i);
            double p = pair.p;
            double s = pair.s;
            double dtt = target - p;
            double ttt = dtt / s;

            while (!fleet.isEmpty() && fleet.peek() <= ttt) {
                fleet.pop();
            }
            fleet.push(ttt);
        }
        return fleet.size();
    }

    class Pair implements Comparable {
        int p;
        int s;
        Pair(int p, int s) {
            this.p = p;
            this.s = s;
        }

        public int compareTo(Object p1) {
            Pair p = (Pair) p1;
            if (this.p > p.p) {
                return 1;
            } else if (this.p > p.p) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
