void main() {
    assert 9 == new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"});
    assert 6 == new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"});
}

class Solution {
    public int evalRPN(String[] tokens) {
        var stack = new ArrayDeque<Integer>();

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+" -> {
                    var rhs = stack.pop();
                    var lhs = stack.pop();
                    stack.push(lhs + rhs);
                }
                case "-" -> {
                    var rhs = stack.pop();
                    var lhs = stack.pop();
                    stack.push(lhs - rhs);
                }
                case "*" -> {
                    var rhs = stack.pop();
                    var lhs = stack.pop();
                    stack.push(lhs * rhs);
                }
                case "/" -> {
                    var rhs = stack.pop();
                    var lhs = stack.pop();
                    stack.push(lhs / rhs);
                }
                default -> stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}