class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length==0)
            return 0;
        Set<String> opertaors = new HashSet();
        opertaors.add("-");
        opertaors.add("+");
        opertaors.add("*");
        opertaors.add("/");
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (!opertaors.contains(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                int res;
                if ("-".equals(str)) {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    res = op2 - op1;
                    stack.push(res);
                } else if ("+".equals(str)) {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    res = op2 + op1;
                    stack.push(res);
                } else if ("*".equals(str)) {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    res = op2 * op1;
                    stack.push(res);
                } else {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    res = op2 / op1;
                    stack.push(res);
                }
            }
        }
        return stack.pop();
    }
}
