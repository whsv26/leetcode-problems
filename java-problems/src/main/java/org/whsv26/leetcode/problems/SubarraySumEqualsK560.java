void main() {
    assert new Solution().subarraySum(new int[] {1, 1, 1}, 2) == 2;
    assert new Solution().subarraySum(new int[] {1, 2, 3}, 3) == 2;
    assert new Solution().subarraySum(new int[] {1, -1, 0}, 0) == 3;

    assert new SolutionPrefix().subarraySum(new int[] {1, 1, 1}, 2) == 2;
    assert new SolutionPrefix().subarraySum(new int[] {1, 2, 3}, 3) == 2;
    assert new SolutionPrefix().subarraySum(new int[] {1, -1, 0}, 0) == 3;
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        var frequencies = new HashMap<Integer, Integer>();
        frequencies.put(0, 1);

        int subarrays = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            subarrays += frequencies.getOrDefault(prefixSum - k, 0);
            frequencies.merge(prefixSum, 1, Integer::sum);
        }

        return subarrays;
    }
}

class SolutionPrefix {
    public int subarraySum(int[] nums, int k) {
        var prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int subarrays = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = prefixSum[j + 1] - prefixSum[i];
                if (sum == k) {
                    subarrays++;
                }
            }
        }

        return subarrays;
    }
}
