void main() {
    assert 4 == new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
}

class Solution {
    public int longestConsecutive(int[] nums) {
        var numSet = new HashSet<Integer>();

        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}