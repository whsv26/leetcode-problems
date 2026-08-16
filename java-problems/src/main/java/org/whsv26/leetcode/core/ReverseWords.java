void main() {
    var words = List.of("java", "is", "fun");
    var joinedWords = "fun is java";
    assert joinReversed(words).equals(joinedWords);
    assert joinReversedStringBuilder(words).equals(joinedWords);
    assert joinReversedStringJoiner(words).equals(joinedWords);
}

String joinReversed(List<String> words) {
    return String.join(" ", words.reversed());
}

String joinReversedStringJoiner(List<String> words) {
    var listIterator = words.listIterator(words.size());
    var joiner = new StringJoiner(" ");
    while (listIterator.hasPrevious()) {
        joiner.add(listIterator.previous());
    }
    return joiner.toString();
}

String joinReversedStringBuilder(List<String> words) {
    var builder = new StringBuilder();
    for (var word : words.reversed()) {
        if (!builder.isEmpty()) {
            builder.append(' ');
        }
        builder.append(word);
    }
    return builder.toString();
}