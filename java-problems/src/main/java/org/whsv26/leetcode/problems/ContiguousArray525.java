void main() {
    assert 2 == new Solution().findMaxLength(new int[]{0, 1});
    assert 2 == new Solution().findMaxLength(new int[]{0, 1, 0});
    assert 6 == new Solution().findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0});
}

class Solution {
    public int findMaxLength(int[] nums) {
        var first = new HashMap<Integer, Integer>();
        first.put(0, -1);

        var prefixSum = 0;
        var maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            prefixSum += nums[j] == 0 ? -1 : 1;

            if (first.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, j - first.get(prefixSum));
            } else {
                first.put(prefixSum, j);
            }
        }

        return maxLen;
    }
}