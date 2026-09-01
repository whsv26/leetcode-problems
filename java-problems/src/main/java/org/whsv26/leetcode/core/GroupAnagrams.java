void main() {
    var res = groupAnagramsLight(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    assert res.equals(
        List.of(
            List.of("eat", "tea", "ate"),
            List.of("bat"),
            List.of("tan", "nat")
        )
    );
}

List<List<String>> groupAnagramsLight(String[] words) {
    var groups = new HashMap<String, List<String>>();

    for (var word : words) {
        var frequencies = new int[26];

        for (int i = 0; i < word.length(); i++) {
            frequencies[word.charAt(i) - 'a']++;
        }

        groups
            .computeIfAbsent(Arrays.toString(frequencies), _ -> new ArrayList<>())
            .add(word);
    }

    return new ArrayList<>(groups.values());
}

List<List<String>> groupAnagramsSorting(String[] words) {
    return Arrays.stream(words).collect(
        Collectors.groupingBy(word -> {
            var chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        })
    ).values().stream().toList();
}

List<List<String>> groupAnagramsFrequency(String[] words) {
    return Arrays.stream(words).collect(
        Collectors.groupingBy(word -> {
            var frequencies = new HashMap<Character, Integer>();
            for (int i = 0; i < word.length(); i++) {
                frequencies.merge(word.charAt(i), 1, Integer::sum);
            }
            return frequencies;
        })
    ).values().stream().toList();
}