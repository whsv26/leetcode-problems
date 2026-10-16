void main() {
    assert Arrays.equals(
        new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}),
        new int[]{1, 1, 4, 2, 1, 1, 0, 0}
    );
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var stack = new ArrayDeque<Integer>();
        var result = new int[temperatures.length];

        for (int right = 0; right < temperatures.length; right++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[right]) {
                var left = stack.pop();
                result[left] = right - left;
            }
            stack.push(right);
        }

        return result;
    }
}