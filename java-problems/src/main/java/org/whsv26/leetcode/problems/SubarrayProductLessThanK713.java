void main() {
    assert 8 == new Solution().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
    assert 48 == new Solution().numSubarrayProductLessThanK(new int[]{686, 28, 455, 675, 605, 29, 942, 48, 502, 889, 854, 206, 231, 796, 272, 565, 887, 969, 558, 13, 22, 455, 145, 804, 15}, 515854);
}

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        var product = 1;
        var result = 0;

        for (int left = 0, right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left++];
            }

            result += (right - left + 1);
        }

        return result;
    }
}

class SolutionArrayDeque {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        var product = 1;
        var result = 0;
        var window = new ArrayDeque<Integer>();

        for (int num : nums) {
            product *= num;
            window.add(num);

            while (product >= k) {
                product /= window.poll();
            }

            result += window.size();
        }

        return result;
    }
}
