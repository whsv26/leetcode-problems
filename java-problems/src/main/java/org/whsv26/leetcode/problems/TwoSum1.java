void main() {
    assert Arrays.equals(
        new Solution().twoSum(new int[]{2, 7, 11, 15}, 9),
        new int[]{0, 1}
    );
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }

        return new int[]{};
    }
}