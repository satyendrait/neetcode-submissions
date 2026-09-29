class MinStack {
    List<Integer> stack = new ArrayList();
    PriorityQueue<Integer> maxHeap = new PriorityQueue();

    public MinStack() {
        stack = new ArrayList();
        maxHeap = new PriorityQueue();
    }

    public void push(int val) {
        stack.add(val);
        maxHeap.add(val);
    }

    public void pop() {
        int i = stack.remove(stack.size() - 1);
        maxHeap.remove(i);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return maxHeap.peek();
    }
}
