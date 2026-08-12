import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

void main() {
    var actual = combinationSum(new int[]{2,3,6,7}, 7);
    assert (actual.equals(
        List.of(
            List.of(2,2,3),
            List.of(7)
        )
    ));
}

List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        combination.add(candidates[i]);
        backtrack(i, remaining - candidates[i], candidates, combinations, combination);
        combination.removeLast();
    }
}
