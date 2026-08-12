import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

void main() {
    var actual = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    assert (actual.equals(
        List.of(
            List.of(1,1,6),
            List.of(1,2,5),
            List.of(1,7),
            List.of(2,6)
        )
    ));
}

List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    var result = new ArrayList<List<Integer>>();
    backtrack(0, target, candidates, result, new ArrayList<>());
    return result;
}

void backtrack(
    int from,
    int remaining,
    int[] candidates,
    List<List<Integer>> combinations,
    List<Integer> combination
) {
    if (remaining == 0) {
        combinations.add(combination.stream().toList());
        return;
    } else if (remaining < 0) {
        return;
    }

    for (int i = from; i < candidates.length; i++) {
        if (i > from && candidates[i] == candidates[i - 1]) {
            continue;
        }
        combination.add(candidates[i]);
        backtrack(i + 1, remaining - candidates[i], candidates, combinations, combination);
        combination.removeLast();
    }
}
