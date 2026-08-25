void main() {
    assert isValid("()[]{}");
    assert isValid("([{}])");
    assert !isValid("(]");
    assert !isValid("((");
    assert !isValid("(");
}

boolean isValid(String s) {
    // Deques can also be used as LIFO stacks. (push, pop, peek)
    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
        var charAt = s.charAt(i);

        if (OPEN_TO_CLOSE.containsKey(charAt)) {
            stack.push(charAt);
        } else if (OPEN_TO_CLOSE.containsValue(charAt)) {
            if (stack.isEmpty() || OPEN_TO_CLOSE.get(stack.pop()) != charAt) {
                return false;
            }
        }
    }

    return stack.isEmpty();
}

static final Map<Character, Character> OPEN_TO_CLOSE = Map.of(
    '(', ')',
    '[', ']',
    '{', '}'
);
