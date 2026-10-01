class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Stack<Pair> pairs = new Stack();
        for (int i = 0; i < temperatures.length; i++) {
            if (pairs.isEmpty() || pairs.peek().v >= temperatures[i]) {
                pairs.push(new Pair(i, temperatures[i]));
            } else {
                Pair p = pairs.peek();
                while (p.v < temperatures[i]) {
                    p = pairs.pop();
                    results[p.i] = i - p.i;
                    if (!pairs.isEmpty()) {
                        p = pairs.peek();
                    } else {
                        break;
                    }
                }
                pairs.push(new Pair(i, temperatures[i]));
            }
        }
        return results;
    }
    class Pair {
        int i;
        int v;
        Pair(int i, int v) {
            this.i = i;
            this.v = v;
        }
    }
}
