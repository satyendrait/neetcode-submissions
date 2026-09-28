class Solution {
    public boolean isValid(String s) {
        Set<Character> open = new HashSet();
        open.add('(');
        open.add('{');
        open.add('[');
        Map<Character, Character> pair = new HashMap();
        pair.put(']', '[');
        pair.put('}', '{');
        pair.put(')', '(');
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (open.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != pair.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
