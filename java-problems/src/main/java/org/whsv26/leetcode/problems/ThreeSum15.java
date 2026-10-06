void main() {
    assert new Solution().threeSum(new int[]{-1,0,1,2,-1,-4}).equals(
        List.of(
            List.of(-1,-1,2),
            List.of(-1,0,1)
        )
    );
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            var left = i + 1;
            var right = nums.length - 1;

            while (left < right) {
                var total = nums[i] + nums[left] + nums[right];
                if (total > 0) {
                    right--;
                } else if (total < 0) {
                    left++;
                } else {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}

class SolutionMap {
    public List<List<Integer>> threeSum(int[] nums) {
        var result = new HashSet<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            var seen = new HashSet<Integer>();

            for (int j = i + 1; j < nums.length; j++) {
                if (seen.contains(nums[j])) {
                    var triplet = Arrays.asList(
                        nums[i],
                        nums[j],
                        -nums[i] - nums[j]
                    );
                    triplet.sort(Integer::compareTo);
                    result.add(triplet);
                }
                seen.add(-nums[i] - nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}