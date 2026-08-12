import java.util.ArrayList;
import java.util.List;

void main() {
    var actual = permute(new int[]{1,2,3});
    assert (actual.equals(
        List.of(
            List.of(1,2,3),
            List.of(1,3,2),
            List.of(2,1,3),
            List.of(2,3,1),
            List.of(3,1,2),
            List.of(3,2,1)
        )
    ));
}

List<List<Integer>> permute(int[] nums) {
    var result = new ArrayList<List<Integer>>();
    backtrack(nums, result, new ArrayList<>());
    return result;
}

void backtrack(int[] nums, List<List<Integer>> subsets, List<Integer> subset) {
    if (subset.size() == nums.length) {
        subsets.add(subset.stream().toList());
        return;
    }

    for (int num : nums) {
        if (!subset.contains(num)) {
            subset.add(num);
            backtrack(nums, subsets, subset);
            subset.removeLast();
        }
    }
}
