void main() {
    assert Objects.equals(removeAdjacentDuplicatesStack("abbaca"), "ca");
    assert Objects.equals(removeAdjacentDuplicatesBuilder("abbaca"), "ca");
}

String removeAdjacentDuplicatesBuilder(String s) {
    var builder = new StringBuilder(s.length());
    for (int i = 0; i < s.length(); i++) {
        var ch = s.charAt(i);

        if (!builder.isEmpty() && ch == builder.charAt(builder.length() - 1)) {
            builder.deleteCharAt(builder.length() - 1);
        } else {
            builder.append(ch);
        }
    }

    return builder.toString();
}

String removeAdjacentDuplicatesStack(String s) {
    var stack = new ArrayDeque<Character>();
    for (int i = 0; i < s.length(); i++) {
        if (!stack.isEmpty() && s.charAt(i) == stack.peek()) {
            stack.pop();
        } else {
            stack.push(s.charAt(i));
        }
    }

    var builder = new StringBuilder(stack.size());
    stack.reversed().forEach(builder::append);
    return builder.toString();
}