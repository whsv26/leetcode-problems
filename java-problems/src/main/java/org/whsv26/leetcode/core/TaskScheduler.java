void main() {
    assert List.of("compile", "test", "deploy").equals(
        scheduleTasksKahn(
            List.of("compile", "test", "deploy"),
            Map.of(
                "compile", List.of("test"),
                "test", List.of("deploy")
            )
        )
    );

    assert List.of("compile", "test", "deploy").equals(
        scheduleTasksDfs(
            List.of("compile", "test", "deploy"),
            Map.of(
                "compile", List.of("test"),
                "test", List.of("deploy")
            )
        )
    );

    var resultKahn = scheduleTasksKahn(
        List.of("compile", "test", "lint", "deploy"),
        Map.of(
            "compile", List.of("test", "lint"),
            "test", List.of("deploy"),
            "lint", List.of("deploy")
        )
    );
    assert List.of("compile", "test", "lint", "deploy").equals(resultKahn) ||
           List.of("compile", "lint", "test", "deploy").equals(resultKahn);

    var resultDfs = scheduleTasksDfs(
        List.of("compile", "test", "lint", "deploy"),
        Map.of(
            "compile", List.of("test", "lint"),
            "test", List.of("deploy"),
            "lint", List.of("deploy")
        )
    );
    assert List.of("compile", "test", "lint", "deploy").equals(resultDfs) ||
           List.of("compile", "lint", "test", "deploy").equals(resultDfs);
}

List<String> scheduleTasksKahn(List<String> tasks, Map<String, List<String>> dependencyGraph) {
    var indegrees = new HashMap<String, Integer>();

    dependencyGraph.forEach((_, deps) ->
        deps.forEach(dep ->
            indegrees.merge(dep, 1, Integer::sum)
        )
    );

    var queue = new ArrayDeque<String>();

    for (var task : tasks) {
        if (indegrees.getOrDefault(task, 0) == 0) {
            queue.offer(task);
        }
    }

    var result = new ArrayList<String>();

    while (!queue.isEmpty()) {
        var task = queue.poll();
        result.add(task);

        dependencyGraph.getOrDefault(task, List.of()).forEach(dep -> {
            if (indegrees.merge(dep, -1, Integer::sum) == 0) {
                queue.offer(dep);
            }
        });
    }

    return result;
}

List<String> scheduleTasksDfs(List<String> tasks, Map<String, List<String>> dependencies) {
    var visited = new HashSet<String>();
    var result = new ArrayList<String>();

    for (var task : tasks) {
        dfs(task, dependencies, visited, result);
    }

    return result.reversed();
}

void dfs(
    String node,
    Map<String, List<String>> graph,
    Set<String> visited,
    List<String> result
) {
    if (!visited.add(node)) {
        return;
    }

    for (var dependency : graph.getOrDefault(node, List.of())) {
        dfs(dependency, graph, visited, result);
    }

    result.add(node);
}
