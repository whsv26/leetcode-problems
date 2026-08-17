void main() {
    var in = List.of("cat", "dog", "java", "go", "code");
    var out = Map.of(
        2, List.of("go"),
        3, List.of("cat", "dog"),
        4, List.of("java", "code")
    );

    assert groupByLength(in).equals(out);
}

Map<Integer, List<String>> groupByLength(List<String> words) {
    var groups = new HashMap<Integer, List<String>>();

    for (String word : words) {
        var group = groups.computeIfAbsent(word.length(), _ -> new LinkedList<>());
        group.add(word);
    }

    return groups;
}

