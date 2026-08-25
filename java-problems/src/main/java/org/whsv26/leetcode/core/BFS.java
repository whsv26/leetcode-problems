void main() {
    assert bfs(Map.of(
        0, List.of(1, 2),
        1, List.of(3),
        2, List.of(4),
        3, List.of(),
        4, List.of()
    ), 0).equals(List.of(0, 1, 2, 3, 4));
}

List<Integer> bfs(Map<Integer, List<Integer>> graph, int start) {
    var visited = new HashSet<Integer>();
    var queue = new ArrayDeque<Integer>();
    var result = new ArrayList<Integer>();

    queue.offer(start);
    visited.add(start);

    while (!queue.isEmpty()) {
        var node = queue.poll();
        result.add(node);

        for (var nextNode : graph.getOrDefault(node, List.of())) {
            if (visited.add(nextNode)) {
                queue.offer(nextNode);
            }
        }
    }

    return result;
}
