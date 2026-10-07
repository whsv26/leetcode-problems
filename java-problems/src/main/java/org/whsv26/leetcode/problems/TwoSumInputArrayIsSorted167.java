void main() {
    assert Arrays.equals(
        new Solution().twoSum(new int[]{2, 7, 11, 15}, 9),
        new int[]{1, 2}
    );
}

class Solution {
    public int[] twoSum(int[] nums, int target) {

        var left = 0;
        var right = nums.length - 1;

        while (left < right) {
            var total = nums[left] + nums[right];
            if (total > target) {
                right--;
            } else if (total < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return new int[]{};
    }
}