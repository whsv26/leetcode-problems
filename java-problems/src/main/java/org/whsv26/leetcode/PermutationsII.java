import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// a0,a1,b2 = a,a,b
// a1,a0,b2 = a,a,b (duplicate)
// a0,b2,a1 = a,b,a
// a1,b2,a0 = a,b,a (duplicate)
// b2,a0,a1 = b,a,a
// b2,a2,a0 = b,a,a (duplicate)
// дубликаты получаются путем перестановки одинаковых элементов
// можно принять, что у дубликата одинаковые элементы будут использоваться в обратном порядке
// например: a1,a0 вместо a0,a1
void main() {
    var actual = permuteUnique(new int[]{1,1,2});
    assert (actual.equals(
        List.of(
            List.of(1,1,2),
            List.of(1,2,1),
            List.of(2,1,1)
        )
    ));
}

List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    var result = new ArrayList<List<Integer>>();
    backtrack(nums, result, new ArrayList<>(), new HashSet<>());
    return result;
}

void backtrack(int[] nums, List<List<Integer>> subsets, List<Integer> subset, Set<Integer> used) {
    if (subset.size() == nums.length) {
        subsets.add(subset.stream().toList());
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        var isRepeated = i > 0 && nums[i] == nums[i - 1];
        if (used.contains(i) || isRepeated && !used.contains(i - 1)) {
            continue;
        }

        subset.add(nums[i]);
        used.add(i);
        backtrack(nums, subsets, subset, used);
        used.remove(i);
        subset.removeLast();
    }
}
