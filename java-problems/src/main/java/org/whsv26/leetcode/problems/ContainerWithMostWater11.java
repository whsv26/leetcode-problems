void main() {
    assert 49 == new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    assert 1 == new Solution().maxArea(new int[]{1, 1});
}

class Solution {
    public int maxArea(int[] height) {
        var left = 0;
        var right = height.length - 1;
        var max = 0;

        while (left < right) {
            var area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}