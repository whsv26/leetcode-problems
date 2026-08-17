void main() {
    var in = "banana";
    var out = Map.of(
        'b', List.of(0),
        'a', List.of(1, 3, 5),
        'n', List.of(2, 4)
    );

    assert buildIndex(in).equals(out);
}

Map<Character, List<Integer>> buildIndex(String s) {
    var map = new HashMap<Character, List<Integer>>();

    for (int i = 0; i < s.length(); i++) {
        map.computeIfAbsent(s.charAt(i), _ -> new ArrayList<>())
            .add(i);
    }

    return map;
}

