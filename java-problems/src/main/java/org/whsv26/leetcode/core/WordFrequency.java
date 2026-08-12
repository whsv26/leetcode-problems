void main() {
    var words = List.of("java", "kotlin", "java", "go", "java", "go");
    var frequencies = Map.of(
        "java", 3,
        "kotlin", 1,
        "go", 2
    );
    assert wordFrequency(words).equals(frequencies);
    assert wordFrequency1(words).equals(frequencies);
}

Map<String, Integer> wordFrequency(List<String> words) {
    var frequencies = new HashMap<String, Integer>();
    for (var word : words) {
        frequencies.merge(word, 1, Integer::sum);
    }
    return frequencies;
}

Map<String, Integer> wordFrequency1(List<String> words) {
    var frequencies = new HashMap<String, Integer>();
    for (var word : words) {
        frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
    }
    return frequencies;
}